from conn import database, connect_db, disconnect_db

def read():
    try:
        conn = db_client()
        cur = conn.cursor()
        cur.execute("select * from ASSIGNATURA")
    
        assigs = cur.fetchall()
    
    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}" }
    
    finally:
        conn.close()
    
    return assigs

def read_id(id):
    try:
        conn = db_client()
        cur = conn.cursor()
        query = "select * from ASSIGNATURA WHERE id = %s"
        value = (id,)
        cur.execute(query,value)
    
        assig = cur.fetchone()
    
    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}" }
    
    finally:
        conn.close()
    
    return assig

def create(nom,descripcio,idProfessor):
    try:
        conn = db_client()
        cur = conn.cursor()
        query = "insert into assignatura (nom,descripcio,idProfessor) VALUES (%s,%s,%s);"
        values = (nom,descripcio,idProfessor)
        cur.execute(query,values)

        conn.commit()
        film_id = cur.lastrowid

    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}"}
    
    finally:
        conn.close()

    return film_id
