SET search_path TO medical;

DELETE FROM medical_card
WHERE id NOT IN (
    SELECT id FROM (
                       SELECT MIN(id) AS id
                       FROM medical_card
                       GROUP BY client_status, med_status, registry_dt, comment
                   ) unique_rows
);