def alumne_schema(student) -> dict:
    return {"IdAlumne": student[0],
            "Nom": student[1],
            "Cognoms": student[2],
            "Email": student[3],
            "Telefon": student[4],
	    "Id_Tarjeta": student[5]
            }

def alumnes_schema(alumnes) -> dict:
    return [alumne_schema(alumne) for alumne in alumnes]
