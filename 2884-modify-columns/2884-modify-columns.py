def modifySalaryColumn(employees: pd.DataFrame) -> pd.DataFrame:
    if employees is None or employees.empty:
        return pd.DataFrame()
    if 'salary' in employees.columns:
        employees['salary'] = employees['salary'] * 2
    return employees