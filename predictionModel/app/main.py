from fastapi import FastAPI
from pydantic import BaseModel
from app.model.model import predict_pipeline as prediction

app = FastAPI()


class ParamsIn(BaseModel):
    params: list = []


class PredScore(BaseModel):
        score: int


@app.get("/")
def home():
    return {"health_check": "OK"}


@app.post("/predict" )
def predict(payload: ParamsIn):
    score = prediction(payload.params)
    response = {"Predicted Score": score}
    return response