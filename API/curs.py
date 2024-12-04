def curs_schema(course) -> dict:
    return {"idCurso": course[0],
            "nom": course[1],
            "any": course[2]
            }

def cursos_schema(cursos) -> dict:
    return [curs_schema(curs) for curs in cursos]