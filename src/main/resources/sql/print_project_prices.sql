SELECT 
    CONCAT('Project ', p.ID) AS NAME, 
    SUM(w.Salary) * (DATEDIFF('MONTH', p.START_DATE, p.FINISH_DATE) + 1) AS PRICE
FROM 
    project p
JOIN 
    project_worker pw ON p.ID = pw.PROJECT_ID
JOIN 
    worker w ON pw.WORKER_ID = w.ID
GROUP BY 
    p.ID
ORDER BY 
    PRICE DESC;