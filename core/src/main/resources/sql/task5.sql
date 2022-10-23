SET search_path TO medical;

SELECT * FROM person_data
ORDER BY id
LIMIT (SELECT COUNT(id)
        FROM person_data)/2;