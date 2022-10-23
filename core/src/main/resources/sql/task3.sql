SET search_path TO medical;

SELECT *
FROM illness AS il
    JOIN medical_card AS med
        ON med.id = il.medical_card_id;