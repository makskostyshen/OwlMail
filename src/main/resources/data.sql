INSERT INTO wizard VALUES ('Kostyshen', 'Maksym', '2023-01-01');
INSERT INTO wizard VALUES ('Malfoy', 'Draco', '2023-01-01');

INSERT INTO owl
    (name, breed, date_of_birth, ownership_start_date, wizard_family_name, wizard_first_name)
VALUES ('Hedwig', 'SNOWY_OWL', '2003-11-01', '2022-12-29', 'Kostyshen', 'Maksym');

INSERT INTO letter
(header, body, date_time, sender_family_name, sender_first_name, owl_id, receiver_family_name, receiver_first_name)
VALUES ('Attention', 'I want to kiss you', '2022-01-17 12:12:12', 'Kostyshen', 'Maksym', 1, 'Malfoy', 'Draco');