from databases import Database

DATABASE_URL = "mysql://123admin:P4assw0ord!@localhost/AccesDB"
database = Database(DATABASE_URL)

async def connect_db():
    await database.connect()

async def disconnect_db():
    await database.disconnect()
