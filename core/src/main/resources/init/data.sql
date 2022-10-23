SET search_path TO medical;

-- medical_card
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (1, 'R', 'S', '2022-05-13', 'Neurology');
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (2, 'C', null, '2022-06-13', 'Cardiology');
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (3, 'R', 'H', '2022-06-20', null);
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (4, 'R', 'S', '2022-06-30', 'Gastroenterology');
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (5, 'R', 'S', '2022-06-30', 'Gastroenterology');
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (6, 'R', 'S', '2022-06-30', 'Gastroenterology');
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (7, 'C', 'H', '2022-06-30', null);
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (8, 'C', 'H', '2022-06-30', 'Hypertension');
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (9, 'C', 'H', '2022-07-30', null);
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (10, 'C', 'S', '2022-08-30', 'Neurology');

-- contact
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (1, '9108862291', 'adcs@gmail.com', 'adcs.com');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (2, '9108862391', 'adc_fsgsg@mail.ru', 'tecdar.ru');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (3, '9308862391', 'adc_fsgsg@gmail.com', 'tecdshs.com');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (4, '9308702391', 'jdjjdj@gmail.com', 'smmsmsm.com');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (5, '9778702391', 'bvbvb@mail.ru', 'nnrnnr.ru');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (6, '9778708991', 'bvbnfnfvb@mail.ru', 'nnrnfnfnnr.ru');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (7, '9778708922', 'daryavgrei@gmail.com', 'vk.com/daryannaa');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (8, '9778708989', 'elena@gmail.com', 'vk.com/elena');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (9, '9607982311', 'dkdkd@list.ru', 'vk.com/dkdkd');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (10, '9607982388', 'ndnnd@list.ru', 'dnndndn.com');

-- address
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (1, 1, 123, 'Moscow', 142780, 'Gorky', '7', '13');
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (2, 2, 123, 'Moscow', null, 'Gorky', '7', null);
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (3, 3, 123, 'Nizhny Novgorod', 603006, 'Belinsky', '20', '45');
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (4, 4, 123, 'Nizhny Novgorod', 603006, 'Belinsky', '50', '12');
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (5, 5, 123, 'Nizhny Novgorod', 603006, 'Gruzinsky', '37A', '16');
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (6, 6, 123, 'Nizhny Novgorod', 603006, 'Gruzinsky', '37A', '22');
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (6, 6, 123, 'Moscow', 142781, 'Gruzinsky', '37A', '75');
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (7, 7, 123, 'Moscow', null, 'Gruzinsky', '37A', '7');
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (8, 8, 123, 'Moscow', null, 'Gorky', '37B', null);
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (9, 9, 123, 'Moscow', null, 'Gorky', '37B', null);
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (10, 10, 123, 'Moscow', null, 'Gorky', '11', null);

-- illness
INSERT INTO illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) VALUES (1, 1, null, null, '2022-05-13', null);
INSERT INTO illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) VALUES (2, 2, 2, 'L', '2022-06-13', '2022-07-20');
INSERT INTO illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) VALUES (3, 3, 2, 'L', '2022-06-20', '2022-07-25');
INSERT INTO illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) VALUES (4, 4, 6, 'S', '2022-07-01', '2022-10-23');
INSERT INTO illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) VALUES (5, 5, 6, 'S', '2022-07-01', '2022-10-23');
INSERT INTO illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) VALUES (6, 6, 6, 'S', '2022-07-01', '2022-10-23');
INSERT INTO illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) VALUES (7, 7, 6, 'S', '2022-07-01', '2022-10-23');
INSERT INTO illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) VALUES (8, 8, 6, 'S', '2022-09-01', '2022-10-23');
INSERT INTO illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) VALUES (9, 10, 6, 'S', '2022-09-01', null);
INSERT INTO illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) VALUES (10, 9, 6, 'S', '2022-09-01', null);

-- person_data
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (1, 'Daryushova', 'Helen', '1992-01-07', null, 'F', 2, 3, 2);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (2, 'Daryushov', 'Vladimir', '1986-01-10', null, 'M', 1, 2, null);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (3, 'Tom', 'Cat', '1970-01-10', null, 'M', 3, 1, null);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (4, 'Kitty', 'Cat', '1970-01-10', null, 'F', 4, 4, 2);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (5, 'Ksenia', 'Lukina', '2000-05-13', 22, 'F', 5, 5, null);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (6, 'Anton', 'Lukin', '1998-05-11', 25, 'M', 6, 6, 4);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (7, 'Alex', 'Alex', '1978-05-11', null, 'M', 7, 7, 8);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (8, 'Kostya', 'Alex', '1960-05-11', null, 'M', 8, 8, null);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (9, 'Fedor', 'Fedor', '1989-05-11', null, 'M', 9, 9, null);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (10, 'Alice', 'Alice', '1990-05-11', null, 'F', 10, 10, null);