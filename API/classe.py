def classe_schema(grade) -> dict:
    return {"idClasse": grade[0],
            "data": grade[1],
            "horaInici": grade[2],
            "horaFi": grade[3],
            "idUF": grade[4],
            "idCurso" : grade[5] 
            }

def classes_schema(classes) -> dict:
    return [classe_schema(classe) for classe in classes]