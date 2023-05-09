from sqlalchemy import Column, Integer, String, Boolean, TIMESTAMP

from .database import Base

class Member(Base):
    __tablename__ = "member"
    member_id = Column(Integer, primary_key=True, unique=True, autoincrement=True)
    email = Column(String)
    name = Column(String)
    profile = Column(String)
    isPublic = Column(Boolean)
    created_at = Column(TIMESTAMP)
    modified_at = Column(TIMESTAMP)

class Tistory(Base):
    __tablename__ = "tistory"
    tistory_id = Column(Integer, primary_key=True, unique=True, autoincrement=True)
    member_id = Column(Integer)
    accessToken = Column(String)
    created_at = Column(TIMESTAMP)
    modified_at = Column(TIMESTAMP)

class Github(Base):
    __tablename__ = "github"
    github_id = Column(Integer, primary_key=True, unique=True, autoincrement=True)
    member_id = Column(Integer)
    account = Column(String)

class Post(Base):
    __tablename__ = "post"
    post_id = Column(Integer, primary_key=True, unique=True, autoincrement=True)
    member_id = Column(Integer)
    title = Column(String)
    contents = Column(String)
    url = Column(String)
    status = Column(String)
    isPublic = Column(Boolean)
    created_at = Column(TIMESTAMP)
    modified_at = Column(TIMESTAMP)