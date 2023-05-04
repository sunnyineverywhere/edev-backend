from pydantic import BaseSettings
import os
from dotenv import load_dotenv

class Settings(BaseSettings):
    BASE_DIR = os.path.dirname(os.path.abspath(__file__))
    load_dotenv(os.path.join(BASE_DIR, ".env"))
    SQLALCHEMY_DATABASE_URL = os.environ["SQLALCHEMY_DATABASE_URL"]