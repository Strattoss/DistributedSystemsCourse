from fastapi import FastAPI
from enum import Enum
from fastapi.responses import JSONResponse

from pydantic import BaseModel

from fastapi import status

app=FastAPI( )

polls = {
    "p_1": {
        "question": "What is the meaning of the world?",
        "available_choices": ["yes", "no", "maybe"],
        "votes": {
            "v_1": {
                "user_id": "u_1",
                "choice": "yes"
            },
            "v_2": {
                "user_id": "u_3",
                "choice": "no"
            },
            "v_3": {
                "user_id": "u_2",
                "choice": "yes"
            }
        }
    }, 
    "p_2": {
        "question": "What would you like to eat tonight?",
        "available_choices": ["dunno", "whatever", "pizza"],
        "votes": { }
    }
}

@app.get("/poll")
async def get_polls():
    return polls


class Poll(BaseModel):
    question: str
    available_choices: list[str]

@app.post("/poll")
async def create_poll(poll: Poll):
    new_key = f"p_{len(polls) + 1}"
    new_poll = {**poll.model_dump(), "votes": {}}
    
    polls[new_key] = new_poll

    return polls[new_key]

@app.get("/poll/{poll_id}")
async def get_poll(poll_id: str):
    if poll_id not in polls:
        return JSONResponse(content=f"Poll with id '{poll_id}' doesn't exist", status_code=status.HTTP_404_NOT_FOUND)
    
    return polls[poll_id]

@app.put("/poll/{poll_id}")
async def update_poll(poll_id: str, poll: Poll):
    if poll_id not in polls:
        return JSONResponse(content=f"Poll with id '{poll_id}' doesn't exist", status_code=status.HTTP_404_NOT_FOUND)
    
    # check if poll has votes, where chosen option is not in the new available choices

    updated_poll = polls[poll_id]

    for key, val in poll.model_dump().items():
        print(key, val)
        updated_poll[key] = val
    
    return polls[poll_id]

@app.delete("/poll/{poll_id}")
async def delete_poll(poll_id:str):
    # should I really return 404 if client tries to delete non-existing poll?
    if poll_id not in polls:
        return JSONResponse(content=f"Poll with id '{poll_id}' doesn't exist", status_code=status.HTTP_404_NOT_FOUND)

    del polls[poll_id]

@app.get('/poll/{poll_id}/vote')
async def get_vote(poll_id: str):
    raise NotImplementedError

@app.post('/poll/{poll_id}/vote')
async def cast_vote(poll_id: str):
    raise NotImplementedError

@app.get('/poll/{poll_id}/vote/{vote_id}')
async def get_vote(poll_id: str, vote_id: str):
    raise NotImplementedError

@app.put('/poll/{poll_id}/vote/{vote_id}')
async def cast_vote(poll_id: str, vote_id: str):
    raise NotImplementedError

@app.delete('/poll/{poll_id}/vote/{vote_id}')
async def cast_vote(poll_id: str, vote_id: str):
    raise NotImplementedError



