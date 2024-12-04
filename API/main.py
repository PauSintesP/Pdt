from conn import database, connect_db, disconnect_db
from typing import List
from pydantic import BaseModel
from fastapi import FastAPI, HTTPException
import db_alumne
import alumne
import db_presencia
import presencia
import db_classe
import classe
import logging
logging.basicConfig(level=logging.DEBUG)
logger = logging.getLogger(__name__)

app = FastAPI()

class AlumneResponse(BaseModel):
    IdAlumne: int
    Nom: str
    Cognoms: str
    Email: str
    Telefon: str | None

class PresenciaRequest(BaseModel):
    IdAlumne: int
    IdCLasse: int
    Present: bool
    Comentaris: str | None = None

@app.on_event("startup")
async def startup():
    if not database.is_connected:
        await connect_db()

@app.on_event("shutdown")
async def shutdown():
    if database.is_connected:
        await disconnect_db()

@app.get("/")
def read_root():
    return {"name": "API REST"}

@app.get("/alumnes", response_model=List[dict])
async def read_alumnes():
    try:
        logging.debug("Iniciando consulta")
        adb = await db_alumne.read()
        logging.debug(f"Resultado de db_alumne.read(): {adb}")
        if adb:
            logger.debug(f"Datos encontrados: {adb}")
            alumne_schema = alumne.alumnes_schema(adb)
            logger.debug(f"Datos después de aplicar el esquema: {alumne_schema}")
            return alumne_schema
        else:
            logger.debug("No se encontraron alumnos o adb está vacío.")
            raise HTTPException(status_code=404, detail="Error en los valores")

    except Exception as e:
        logger.error(f"Error capturado: {str(e)}")
        raise HTTPException(status_code=500, detail=str(e))

@app.post("/presencia", response_model=List[dict])
async def ask_presencia():
    try:
        pdb = await db_presencia.read()

        if pdb:
            presencia_schema = presencia.presencias_schema(pdb)
            return presencia_schema
        else:
            raise HTTPException(status_code=404, detail="Error en los valores")

    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))
