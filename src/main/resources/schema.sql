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
    breed VARCHAR(255),
    date_of_birth DATE,
    name VARCHAR(255),
    ownership_start_date DATE,
    wizard_family_name VARCHAR(255),
    wizard_first_name VARCHAR(255),
    FOREIGN KEY (wizard_family_name, wizard_first_name)
        REFERENCES wizard (family_name, first_name)
);