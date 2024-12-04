def materia_schema(materia) -> dict:
    return {"idAssignatura": materia[0],
            "nom": materia[1],
            "descripcio": materia[2],
            "idProfessor": materia[3]
            }

def materias_schema(subjs) -> dict:
    return [materia_schema(subj) for subj in subjs]