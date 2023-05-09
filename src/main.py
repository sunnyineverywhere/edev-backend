from typing import Union, Dict
from fastapi import FastAPI, Depends
import uvicorn
from fastapi.middleware.cors import CORSMiddleware
from sqlalchemy.orm import Session

import db_model.database
import db_model.models
import db_model.crud

db_model.models.Base.metadata.create_all(bind=db_model.database.engine)

app = FastAPI(
    title="E-DEVELOPERS SERVER",
    description="for e-dev website",
    version="1.0.0"
)

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_methods=["*"],
    allow_headers=["*"],
    allow_credentials=True
)


def get_db():
    db = db_model.database.SessionLocal()
    try:
        yield db
    finally:
        db.close()


@app.get("/")
async def root():
    return "Hello! This is dev_ewha's API Server";


@app.get("/posts", tags=["posts"])
async def find_posts(db: Session = Depends(get_db)):
    post_response_dto_list = []
    posts = db_model.crud.get_all_posts(db=db)
    return posts


@app.post("/auth", tags=["auth"])
async def google_auth():
    return "google oauth2"
