from enum import Enum
from json import JSONDecodeError

from fastapi import Body, FastAPI, Form, Request, status
from fastapi.responses import HTMLResponse, JSONResponse
from fastapi.templating import Jinja2Templates

from starlette.responses import FileResponse 

import httpx
import asyncio
import re
import time

PALETTE_GENERATOR_URL = "http://colormind.io/api/"
COLOR_DETAILS_URL = "https://www.thecolorapi.com/id"
COLOR_DETAILS_BASE_URL = "https://www.thecolorapi.com"

app = FastAPI(title="Color-ful app")
templates = Jinja2Templates(directory="templates")

class Bool(str, Enum):
    true = "true"
    false = "false"


@app.get("/", response_class=HTMLResponse)
async def home(request: Request):
    return FileResponse("./static/index.html")

@app.post("/palette/", response_class=HTMLResponse)
async def get_color(request: Request, color_hex: str = Form(...), details_requested: Bool = Form(...), api_key: str = Form(...)):
    start_time = time.time()

    ### Validation
    with open("api_keys.txt") as api_keys:
        read_key = api_keys.readline().strip()
        while read_key != "":
            print("read:" + read_key)
            print("api:" + api_key)
            if read_key == api_key:
                print("match")
                break
            read_key = api_keys.readline().strip()
        else: # if while ends naturally i.e. without breaking i.e. key is incorrect
            return JSONResponse(status_code=status.HTTP_401_UNAUTHORIZED, content=f"The api key is not valid")
    if not re.compile(r'#[0-9a-fA-F]{6}').fullmatch(color_hex):
        return JSONResponse(status_code=status.HTTP_422_UNPROCESSABLE_ENTITY, content=f"The color {color_hex} is not a valid color. Please use hexadecimal representation, for example '#123456'")
    if not re.compile(r'(true)|(false)').fullmatch(details_requested):
        return JSONResponse(status_code=status.HTTP_422_UNPROCESSABLE_ENTITY, content=f"The property 'details' has value {details_requested}. It has to be 'true' or 'false'")
    
    details_requested = details_requested == 'true'

    ### REST requests
    color_rgb = tuple(int(color_hex.lstrip("#")[i:i+2], 16) for i in (0, 2, 4))
    try:
        palette = await generate_palette(color_rgb)

        if details_requested:
            tasks = [ask_for_color_details(color) for color in palette]
            raw_palette_details = await asyncio.gather(*tasks)
    except httpx.HTTPStatusError as e:
        return JSONResponse(status_code=status.HTTP_502_BAD_GATEWAY, content={"user_message" : f"An HTTP error occured while trying to connect with {e.response.url}"})
    except BadDataFormatException as e:
        return JSONResponse(status_code=status.HTTP_502_BAD_GATEWAY, content={"user_message": f"Server at {e.response_url} returned unexpected data", "error_message": e.message})
    except httpx.RequestError as e:
        return JSONResponse(status_code=status.HTTP_504_GATEWAY_TIMEOUT, content={"user_message": f"A timeoute occured while waiting for a response from {e.request.url}"})
    
    ### Data processing
    template_context = {"user_color_hex": color_hex, "user_color_rgb": color_rgb, "palette": palette}
    if details_requested:
        processing_result = process_color_details(raw_palette_details)
        if type(processing_result) == JSONResponse:
            return processing_result
        else:
            template_context["palette_details"] = processing_result

    end_time = time.time()
    template_context["waiting_time"] = f'{end_time-start_time:.3}'
    return JSONResponse(status_code=status.HTTP_200_OK, content=template_context)
    # if you want to return HTML, use the code below
    # return templates.TemplateResponse(name="palette.html", request=request, context=template_context)

def process_color_details(raw_palette_details: list[dict]) -> list[dict] | JSONResponse:
    properties = ["hex", "rgb", "hsl", "hsv", "cmyk", "XYZ"]
    colors = []
    try:
        for raw_color_details in raw_palette_details:
            color_details = {
                "details": {
                    **{prop: raw_color_details[prop]["value"] for prop in properties}
                },
                "name": raw_color_details["name"],
                "contrast_color": raw_color_details["contrast"]["value"],
                "href": COLOR_DETAILS_BASE_URL + raw_color_details["_links"]["self"]["href"]
            }
            colors.append(color_details)
    except JSONDecodeError as e:
        return JSONResponse(status_code=status.HTTP_502_BAD_GATEWAY, content={"user_message": f"Data returned from services doesn't have expected keys and properties"})

    return colors

async def generate_palette(color_rgb: tuple[int]) -> list[tuple[int]]:
    response = await httpx.AsyncClient().post(url=PALETTE_GENERATOR_URL, json={"input": [color_rgb, "N", "N", "N", "N"], "model": "default"})
    response.raise_for_status()

    try:
        response_json = response.json()
    except JSONDecodeError as _:
        raise BadDataFormatException(message=f"Couldn't convert received data to json", response_url=response.url)
    
    if "result" not in response_json:
        raise BadDataFormatException(message=f"Response doesn't contain 'result' key", response_url=response.url)
    
    return list(map(lambda x: tuple(x), response_json["result"]))

async def ask_for_color_details(color_rgb: list[int]) -> dict:
    async with httpx.AsyncClient() as client:
        response = await client.get(url=COLOR_DETAILS_URL, params={"rgb": ",".join(map(str, color_rgb)), "format": "json"})
        response.raise_for_status()

        try:
            response_json = response.json()
        except JSONDecodeError as _:
            raise BadDataFormatException(message=f"Couldn't convert received data to json", response_url=response.url)

        if "code" in response_json:
            raise BadDataFormatException(message=f"Responded with {response_json['code']} status code", response_url=response.url)
        
        return response_json

class BadDataFormatException(Exception):
    "Raised when data has been acquired successfully from an outer service, but the data format or data properties are unexpected"
    def __init__(self, message: str, response_url: str) -> None:
        self.message = message
        self.response_url = response_url
        super().__init__(message, response_url)