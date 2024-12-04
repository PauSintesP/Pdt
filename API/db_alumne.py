import logging
from conn import database, connect_db, disconnect_db

logging.basicConfig(level=logging.DEBUG)

async def read():
    try:
        query = "SELECT * FROM ALUMNE"
        logging.debug("Ejecutando consulta")

        q = await database.fetch_all(query=query)
        logging.debug("Consulta ejecutada")
        return q

    except Exception as e:
        logging.error(f"Error de conexión: {e}")
        return {"status": -1, "message": f"Error de connexió:{e}" }

    finally:
        logging.debug("Operación finalizada")

async def read_id(id: int):
    try:
        query = "SELECT * FROM ALUMNE WHERE IdAlumne = %s"
        q = await database.fetch_one(query=query, values={"id" : id})
        return q

    except Exception as e:
        logging.error(f"Error de conexión: {e}")
        return {"status": -1, "message": f"Error de connexió:{e}" }

    finally:
        logging.debug("Operación finalizada")

def create(Nom,Cognoms,Email,Telefon):
    try:
        conn = db_client()
        cur = conn.cursor()
        query = "insert into ALUMNE (Nom,Cognom,Email,Telefon) VALUES (%s,%s,%s,%s);"
        values = (nom,cognom,email,telefon)
        cur.execute(query,values)

        conn.commit()
        alumne_id = cur.lastrowid

    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}"}
    
    finally:
        conn.close()

    return alumne_id
