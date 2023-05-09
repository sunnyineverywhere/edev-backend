from . import models
from sqlalchemy.orm import Session

def get_all_posts(db: Session):
    posts = db.query(models.Post).all()
    return posts