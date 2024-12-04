from conn import database, connect_db, disconnect_db

def read():
    try:
        conn = db_client()
        cur = conn.cursor()
        cur.execute("select * from professor")
    
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
        query = "select * from professor WHERE id = %s"
        value = (id,)
        cur.execute(query,value)
    
        film = cur.fetchone()
    
    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}" }
    
    finally:
        conn.close()
    
    return film

def create(nom,cognoms,email):
    try:
        conn = db_client()
        cur = conn.cursor()
        query = "insert into professor (nom,cognoms,email) VALUES (%s,%s,%s);"
        values = (nom,cognoms,email)
        cur.execute(query,values)

        conn.commit()
        film_id = cur.lastrowid

    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}"}
    
    finally:
        conn.close()

    return film_id
