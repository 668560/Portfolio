-- Skript for å opprette databasen og legge inn litt data
--Oppgave 1 lab Komme igang med JPA dat107


-- FARE !!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS oblig3dat107_jpa CASCADE;
CREATE SCHEMA oblig3dat107_jpa;
SET search_path TO oblig3dat107_jpa;

-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE IF EXISTS todo CASCADE;

CREATE TABLE ansatt (
	ansattid SERIAL PRIMARY KEY,
    brukernavn VARCHAR(12) UNIQUE NOT NULL , --etter undersøkimg virkerdet som det  ikke finnes metode for å sett min verdi i sql, uten å bruke feks php,
    fornavn VARCHAR(30) NOT NULL,
    etternavn VARCHAR(30) NOT NULL,
    ansettelsesdato DATE NOT NULL,
    stilling VARCHAR NOT NULL,
    maanedslonn DECIMAL NOT NULL
    --add column avdelingid  INT REFERENCES avdeling (avdelingid);
);

CREATE TABLE avdeling (
	avdelingid SERIAL PRIMARY KEY,
	navn VARCHAR UNIQUE NOT NULL,	
	sjef INT REFERENCES ansatt NOT NULL
	);
	
	
	ALTER TABLE ansatt 
	add column avdelingid  INT REFERENCES avdeling (avdelingid);

	
	
CREATE TABLE prosjekt (
	prosjektid SERIAL PRIMARY KEY,
	prosjektnavn VARCHAR NOT NULL, 
	prosjektbeskrivelse VARCHAR
	
);

CREATE TABLE ansattprosjekt (

ansattid INT REFERENCES ansatt(ansattid),
prosjektid INT REFERENCES prosjekt(prosjektid),
PRIMARY KEY(ansattid, prosjektid),
arbeidstimer FLOAT NOT NULL,
rolle varchar

);



INSERT INTO
  ansatt(brukernavn, fornavn, etternavn, ansettelsesdato, stilling, maanedslonn )
VALUES
   ('donald1','Donald', 'Dvassk', '2019-10-02','bartender',12.50 ),
   ('mikke1','Mikke', 'Musk', '2012-10-04','sjofor',13.00 ),
   ('langbein1','Langbein', 'Hund', '2010-03-12','kaptein',14.50 );
  
   
   
   
   INSERT INTO
  avdeling(navn, sjef )
VALUES
   ('Avdeling1', 1);
   

SELECT * FROM ansatt;


insert into oblig3dat107_jpa.avdeling(navn,sjef)
values ('Kaffiautomatgjengen',2),
('Unnasluntrerne1',1),
('brusautomatgjengen',3);

SELECT * FROM oblig3dat107_jpa.avdeling;

insert into oblig3dat107_jpa.prosjekt(prosjektnavn,prosjektbeskrivelse)
values ('drikke','Drikke mest mulig'),
('lure seg unna','mest mulig');


--INSERT INTO
--  ansatt(brukernavn, fornavn, etternavn, ansettelsesdato, stilling, maanedslonn,avdelingid )
-- ('hinkel1','Hinkel','Pinkel','2010-03-14','Barnehageassistent',123.4, 4),
 ('Ole1','Ole','Brum','1950-03-04','Bamse',10.4, 4);
 
SELECT * FROM oblig3dat107_jpa.prosjekt;
    
