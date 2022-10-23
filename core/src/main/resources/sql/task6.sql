SET search_path TO medical;

SELECT child.last_name AS child_l_name,
       child.first_name AS child_f_name,
       child.birth_dt AS child_dob,
       child.parent_id AS par_id,
       par.last_name AS parent_l_name,
       par.first_name AS parent_f_name,
       par.birth_dt AS parent_dob
FROM person_data AS child JOIN person_data AS par ON child.parent_id=par.id
WHERE par.medical_card_id IN (
    SELECT id
    FROM medical_card
    WHERE med_status is null
);