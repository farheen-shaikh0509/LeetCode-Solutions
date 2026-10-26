import pandas as pd

def selectFirstRows(employees: pd.DataFrame) -> pd.DataFrame:
    if employees is None or employees.empty:
        return pd.DataFrame()
    return employees.head(3)