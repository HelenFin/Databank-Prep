SELECT 'OLDEST' AS TYPE, Name, Birthday
FROM worker
WHERE Birthday = (SELECT MIN(Birthday) FROM worker)

UNION ALL

SELECT 'YOUNGEST' AS TYPE, Name, Birthday
FROM worker
WHERE Birthday = (SELECT MAX(Birthday) FROM worker);
