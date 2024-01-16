CREATE TABLE RESTAURANT (
    id SERIAL PRIMARY KEY,
    name VARCHAR2(255),
    city VARCHAR2(255),
    state VARCHAR2(2),
    zip_code VARCHAR2(10),
    phone_number VARCHAR2(20),
    website VARCHAR2(255),
    overall_score NUMBER,
    egg_score NUMBER,
    peanut_score NUMBER,
    dairy_score NUMBER
);

insert into RESTAURANT (id, name, city, state, zip_code, phone_number, website, overall_score, egg_score) values (hibernate_sequence.nextval, 'Bareburger', 'New York', 'NY', '10019', '212-685-2273', 'https://www.bareburger.com/', 5, 5);
insert into RESTAURANT (id, name, city, state, zip_code, phone_number, overall_score, peanut_score) values (hibernate_sequence.nextval, 'Agave Restaurant', 'Atlanta', 'GA', '30312', '404-588-0006', 5, 5);
insert into RESTAURANT (id, name, city, state, zip_code, overall_score, dairy_score) values (hibernate_sequence.nextval, 'Erin McKenna''s Bakery NYC', 'Los Angeles', 'CA', '90004', 5, 5);
insert into RESTAURANT (id, name, city, state, zip_code, phone_number, overall_score, peanut_score) values (hibernate_sequence.nextval, 'El Rancho Viejo', 'Battle Ground', 'WA', '98604', '360-687-0515', 5, 5);
insert into RESTAURANT (id, name, city, state, zip_code, website, overall_score, egg_score) values (hibernate_sequence.nextval, 'Hawthorne Fish House', 'Portland', 'OR', '97215', 'http://corbettfishhouse.com/', 5, 5);