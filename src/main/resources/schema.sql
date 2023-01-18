DROP TABLE IF EXISTS letter;
DROP TABLE IF EXISTS owl;
DROP TABLE IF EXISTS wizard;


CREATE TABLE wizard (
    family_name VARCHAR(255),
    first_name VARCHAR(255),
    registration_date DATE,
    PRIMARY KEY (family_name, first_name)
);

CREATE TABLE owl (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    breed VARCHAR(255),
    date_of_birth DATE,
    ownership_start_date DATE,
    wizard_family_name VARCHAR(255),
    wizard_first_name VARCHAR(255),
    FOREIGN KEY (wizard_family_name, wizard_first_name)
        REFERENCES wizard (family_name, first_name)
);

CREATE TABLE letter(
    id BIGSERIAL PRIMARY KEY,
    header VARCHAR(255),
    body VARCHAR(255),
    date_time TIMESTAMP,
    sender_family_name VARCHAR(255),
    sender_first_name VARCHAR(255),
    owl_id INT,
    receiver_family_name VARCHAR(255),
    receiver_first_name VARCHAR(255),
    FOREIGN KEY (sender_family_name, sender_first_name)
        REFERENCES wizard (family_name, first_name),
    FOREIGN KEY (owl_id) REFERENCES owl (id),
    FOREIGN KEY (receiver_family_name, receiver_first_name)
        REFERENCES wizard (family_name, first_name)
);
