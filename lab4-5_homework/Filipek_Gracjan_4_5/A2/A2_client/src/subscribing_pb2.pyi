from google.protobuf.internal import containers as _containers
from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class Category(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = ()
    FOODS: _ClassVar[Category]
    CLOTHES: _ClassVar[Category]
    ELECTRONICS: _ClassVar[Category]
    APPLIANCES: _ClassVar[Category]
    MISCELLANEOUS: _ClassVar[Category]
FOODS: Category
CLOTHES: Category
ELECTRONICS: Category
APPLIANCES: Category
MISCELLANEOUS: Category

class OfferFilter(_message.Message):
    __slots__ = ("categories", "minimalPrice", "maximalPrice", "minimalAvailableAmount", "maximalAvailableAmount")
    CATEGORIES_FIELD_NUMBER: _ClassVar[int]
    MINIMALPRICE_FIELD_NUMBER: _ClassVar[int]
    MAXIMALPRICE_FIELD_NUMBER: _ClassVar[int]
    MINIMALAVAILABLEAMOUNT_FIELD_NUMBER: _ClassVar[int]
    MAXIMALAVAILABLEAMOUNT_FIELD_NUMBER: _ClassVar[int]
    categories: _containers.RepeatedScalarFieldContainer[str]
    minimalPrice: float
    maximalPrice: float
    minimalAvailableAmount: int
    maximalAvailableAmount: int
    def __init__(self, categories: _Optional[_Iterable[str]] = ..., minimalPrice: _Optional[float] = ..., maximalPrice: _Optional[float] = ..., minimalAvailableAmount: _Optional[int] = ..., maximalAvailableAmount: _Optional[int] = ...) -> None: ...

class Offer(_message.Message):
    __slots__ = ("offer_id", "title", "category", "description", "price_integer_part", "price_decimal_part", "available_amount")
    OFFER_ID_FIELD_NUMBER: _ClassVar[int]
    TITLE_FIELD_NUMBER: _ClassVar[int]
    CATEGORY_FIELD_NUMBER: _ClassVar[int]
    DESCRIPTION_FIELD_NUMBER: _ClassVar[int]
    PRICE_INTEGER_PART_FIELD_NUMBER: _ClassVar[int]
    PRICE_DECIMAL_PART_FIELD_NUMBER: _ClassVar[int]
    AVAILABLE_AMOUNT_FIELD_NUMBER: _ClassVar[int]
    offer_id: int
    title: str
    category: Category
    description: str
    price_integer_part: int
    price_decimal_part: int
    available_amount: int
    def __init__(self, offer_id: _Optional[int] = ..., title: _Optional[str] = ..., category: _Optional[_Union[Category, str]] = ..., description: _Optional[str] = ..., price_integer_part: _Optional[int] = ..., price_decimal_part: _Optional[int] = ..., available_amount: _Optional[int] = ...) -> None: ...

class CreateSubscriptionRequest(_message.Message):
    __slots__ = ("user_id", "offer_filter")
    USER_ID_FIELD_NUMBER: _ClassVar[int]
    OFFER_FILTER_FIELD_NUMBER: _ClassVar[int]
    user_id: int
    offer_filter: OfferFilter
    def __init__(self, user_id: _Optional[int] = ..., offer_filter: _Optional[_Union[OfferFilter, _Mapping]] = ...) -> None: ...

class CreateSubscriptionResponse(_message.Message):
    __slots__ = ("user_id", "subscription_id")
    USER_ID_FIELD_NUMBER: _ClassVar[int]
    SUBSCRIPTION_ID_FIELD_NUMBER: _ClassVar[int]
    user_id: int
    subscription_id: int
    def __init__(self, user_id: _Optional[int] = ..., subscription_id: _Optional[int] = ...) -> None: ...

class SubscribeRequest(_message.Message):
    __slots__ = ("user_id", "subscription_id")
    USER_ID_FIELD_NUMBER: _ClassVar[int]
    SUBSCRIPTION_ID_FIELD_NUMBER: _ClassVar[int]
    user_id: int
    subscription_id: int
    def __init__(self, user_id: _Optional[int] = ..., subscription_id: _Optional[int] = ...) -> None: ...

class SubscribeResponse(_message.Message):
    __slots__ = ("subscription_id", "response_id", "offer")
    SUBSCRIPTION_ID_FIELD_NUMBER: _ClassVar[int]
    RESPONSE_ID_FIELD_NUMBER: _ClassVar[int]
    OFFER_FIELD_NUMBER: _ClassVar[int]
    subscription_id: int
    response_id: int
    offer: Offer
    def __init__(self, subscription_id: _Optional[int] = ..., response_id: _Optional[int] = ..., offer: _Optional[_Union[Offer, _Mapping]] = ...) -> None: ...
