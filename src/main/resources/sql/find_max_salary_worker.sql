SELECT Name, Salary
FROM worker
WHERE Salary = (SELECT MAX(Salary) FROM worker);