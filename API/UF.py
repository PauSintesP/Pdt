def UF_schema(uf) -> dict:
    return {"idUf": uf[0],
            "nom": uf[1],
            "idAssignatura": uf[2],
            "percentatgeMinAssist": uf[3]
            }

def UFS_schema(units) -> dict:
    return [UF_schema(unit) for unit in units]