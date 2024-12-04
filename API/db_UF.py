from conn import database, connect_db, disconnect_db

def read():
    try:
        conn = db_client()
        cur = conn.cursor()
        cur.execute("select * from uf")
    
        films = cur.fetchall()
    
    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}" }
    
    finally:
        conn.close()
    
    return films

def read_id(id):
    try:
        conn = db_client()
        cur = conn.cursor()
        query = "select * from uf WHERE id = %s"
        value = (id,)
        cur.execute(query,value)
    
        film = cur.fetchone()
    
    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}" }
    
    finally:
        conn.close()
    
    return film

def create(nom,idAssignatura,percentatgeMinAssist):
    try:
        conn = db_client()
        cur = conn.cursor()
        query = "insert into uf (nom,idAssignatura,percentatgeMinAssist) VALUES (%s,%s,%s);"
        values = (nom,idAssignatura,percentatgeMinAssist)
        cur.execute(query,values)

        conn.commit()
        film_id = cur.lastrowid

    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}"}
    
    finally:
        conn.close()

    return film_id
