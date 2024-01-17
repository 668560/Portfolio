
DROP SCHEMA IF EXISTS deltager CASCADE;
CREATE SCHEMA deltager;
SET search_path TO deltager;


CREATE TABLE deltager
(
	mobil CHARACTER (8) PRIMARY KEY,
    fornavn VARCHAR(40) NOT NULL,
    etternavn VARCHAR(40) NOT NULL,
    hash VARCHAR (64) NOT NULL,
    salt VARCHAR (32) NOT NULL,
    kjonn CHARACTER VARYING (6)   
   
   -- FOREIGN KEY (avdeling_id) REFERENCES avdeling(id)
);

-- 


INSERT INTO
  deltager(mobil, fornavn, etternavn, hash, salt, kjonn)
VALUES
    ('12343234','Atle', 'Hansen', 'ertrert', 'nnn', 'M'),
    ('12345678', 'Anne', 'Knudsen', 'fdsdf','nnn','K'),
    ('98767898','Knut', 'Markussen', 'fdsdfds','nnn', 'K'),
    ('23432343','Kine', 'Eilertsen', 'fdsdfdsd','nnn', 'K'),
    ('45434543','Erik', 'Danielsen', 'dsd', 'nnn', 'M'),
    ('43444444','Elin', 'Kristinsen', 'sdsds', 'nnn', 'K');
    