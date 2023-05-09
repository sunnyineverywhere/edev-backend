import os

from sqlalchemy import create_engine
from sqlalchemy.pool import NullPool
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
from dotenv import load_dotenv

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
load_dotenv(os.path.join(BASE_DIR, "../.env"))

RDS_PG_URL = os.environ["RDS_PG_URL"]

engine = create_engine(
    RDS_PG_URL, 
    pool_recycle=3600, 
    echo=True, 
    poolclass=NullPool)

SessionLocal = sessionmaker(autoflush=False, bind=engine)

Base = declarative_base();