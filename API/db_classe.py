from conn import database, connect_db, disconnect_db

def read():
    try:
        conn = db_client()
        cur = conn.cursor()
        cur.execute("select * from CLASSE")
    
        clas = cur.fetchall()
    
    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}" }
    
    finally:
        conn.close()
    
    return clas

def read_id(id):
    try:
        conn = db_client()
        cur = conn.cursor()
        query = "select * from CLASSE WHERE IdClasse = %s"
        value = (id,)
        cur.execute(query,value)
    
        clas = cur.fetchone()
    
    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}" }
    
    finally:
        conn.close()
    
    return clas

def create(Data,HoraInici,HoraFi,IdUF,IdCurso):
    try:
        conn = db_client()
        cur = conn.cursor()
        query = "insert into CLASSE (Data,HoraInici,HoraFi,IdUF,IdCurso) VALUES (%s,%s,%s,%s,%s);"
        values = (Data,HoraInici,HoraFi,IdUF,IdCurso)
        cur.execute(query,values)

        conn.commit()
        clas_id = cur.lastrowid

    except Exception as e:
        return {"status": -1, "message": f"Error de connexió:{e}"}
    
    finally:
        conn.close()

    return clas_id
