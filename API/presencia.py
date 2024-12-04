def presencia_schema(presence) -> dict:
    return {"IdPresencia": presence[0],
            "IdAlumne": presence[1],
            "IdClasse": presence[2],
            "Present": presence[3],
            "Comentaris": presence[4]
            }

def presencias_schema(presences) -> list:
    return [presencia_schema(presence) for presence in presences]
