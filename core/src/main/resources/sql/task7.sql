SET search_path TO medical;

CREATE OR REPLACE VIEW person_illness_information AS
SELECT p.last_name, p.first_name, p.birth_dt, il.id AS illness_id
FROM person_data AS p left join medical_card AS med ON p.medical_card_id = med.id
                                   join illness AS il ON med.id = il.medical_card_id;

