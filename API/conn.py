import mysql.connector

def db_client():
    
    try:
        dbname = ""
        user = ""
        password = ""
        host = "localhost"
        port = "3306"
        collation = "utf8mb4_general_ci"
        
        return mysql.connector.connect(
            host = host,
            port = port,
            user = user,
            password = password,
            database = dbname,
            collation = collation
        ) 
            
    except Exception as e:
            return {"status": -1, "message": f"Error de connexió:{e}" }