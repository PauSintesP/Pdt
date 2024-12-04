def profe_schema(profe) -> dict:
    return {"idProfessor": profe[0],
            "nom": profe[1],
            "cognoms": profe[2],
            "email": profe[3]
            }

def profes_schema(teachs) -> dict:
    return [profe_schema(teacher) for teacher in teachs]