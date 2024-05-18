SELECT 
    CONCAT('Project', p.ID) AS NAME,
    DATEDIFF('MONTH', p.START_DATE, p.FINISH_DATE) AS MONTH_COUNT
FROM 
    project p
WHERE 
    DATEDIFF('MONTH', p.START_DATE, p.FINISH_DATE) = (
        SELECT 
            MAX(DATEDIFF('MONTH', p2.START_DATE, p2.FINISH_DATE))
        FROM 
            project p2
    );