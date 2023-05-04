from typing import Union
from fastapi import FastAPI
from config import Settings
import os
from dotenv import load_dotenv

# BASE_DIR = os.path.dirname(os.path.abspath(__file__))
# load_dotenv(os.path.join(BASE_DIR, ".env"))
app = FastAPI()
settings = Settings()

@app.get("/")
async def root():
    env = settings.SQLALCHEMY_DATABASE_URL
    return {"result": env}