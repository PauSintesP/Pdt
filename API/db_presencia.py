import logging
from conn import database, connect_db, disconnect_db

logging.basicConfig(level=logging.DEBUG)

async def read():
    try:
        query = "SELECT * FROM PRESENCIA"
        logging.debug("Ejecutando consulta")

        q = await database.fetch_all(query=query)
        logging.debug("Consulta ejecutada")

        return q

    except Exception as e:
        logging.error(f"Error de conexión: {e}")
        return {"status": -1, "message": f"Error de connexió:{e}"}

    finally:
        logging.debug("Operación finalizada")

async def read_id(id: int):
    try:
        await connect_db()
        query = "SELECT * FROM PRESENCIA WHERE IdPresencia = %s"
        q = await database.fetch_one(query=query, values={"id": id})
        return q

    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}" }

    finally:
        await disconnect_db()

def create(IdAlumne,IdClasse,Present,Comentaris):
    try:
        conn = db_client()
        cur = conn.cursor()
        query = "insert into PRESENCIA (IdAlumne,IdClasse,Present,Comentaris) VALUES (%s,%s,%s,%s);"
        values = (present,comentaris)
        cur.execute(query,values)

        conn.commit()
        pres_id = cur.lastrowid

    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}"}

    finally:
        conn.close()

    return pres_id
