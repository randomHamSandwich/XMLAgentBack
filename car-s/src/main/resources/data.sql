
insert into user (user_type, phone_number,street_number, country, email, city, password,  street, isdeleted)
values ('END_USER', '111111111111', '15', 'Srbija', 'peraspringuser19@gmail.com', 'Novi Sad',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'Gogoljeva', false);
 

insert into user (user_type, phone_number,street_number, country, email, city, password, street, isdeleted)
values ('ADMIN', '909090909090909090', '15', 'Srbija', 'admin@gmail.com', 'Novi Sad',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'Cara Dusana', false);
 

insert into user (user_type, phone_number,street_number, country, email, city, password,  street, isdeleted)
values ('END_USER', '111111111111', '21', 'Srbija', 'mirjanaspringuser19@gmail.com', 'Beograd',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'Golubinacka', false);
 

insert into user (user_type, phone_number,street_number, country, email, city, password,  street, isdeleted)
values ('END_USER','909090909090909090', '64', 'Srbija', 'lugaspring@gmail.com ', 'Kikinda',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'Zlatiborska', false);
 

INSERT INTO car_brand (name, isdeleted)
VALUES ('Mitsubishi',false);

INSERT INTO car_brand (name, isdeleted)
VALUES ('Suzuki',false);

INSERT INTO car_brand (name, isdeleted)
VALUES ('Toyota',false);

INSERT INTO car_brand (name, isdeleted)
VALUES ('Honda',false);

INSERT INTO car_class (name, isdeleted)
VALUES ('Sedan',false);

INSERT INTO car_class (name, isdeleted)
VALUES ('SUV',false);

INSERT INTO car_class (name, isdeleted)
VALUES ('Limousine',false);

INSERT INTO car_class (name, isdeleted)
VALUES ('Convertible',false);

INSERT INTO car_class (name, isdeleted)
VALUES ('Sport',false);

INSERT INTO car_model (name, isdeleted)
VALUES ('Corolla',false);

INSERT INTO car_model (name, isdeleted)
VALUES ('Yaris',false);

INSERT INTO car_model (name, isdeleted)
VALUES ('Samurai',false);

INSERT INTO car_model (name, isdeleted)
VALUES ('Vitara',false);

INSERT INTO car_model (name, isdeleted)
VALUES ('Pajero',false);

INSERT INTO car_model (name, isdeleted)
VALUES ('Accord',false);

INSERT INTO car_model (name, isdeleted)
VALUES ('Evo',false);

INSERT INTO fuel_type (name, isdeleted)
VALUES('TNG',false);

INSERT INTO fuel_type (name, isdeleted)
VALUES('Gasoline',false);

INSERT INTO fuel_type (name, isdeleted)
VALUES('Diesel',false);

INSERT INTO fuel_type (name, isdeleted)
VALUES('Electric',false);

INSERT INTO gearbox_type (name, isdeleted)
VALUES ('Manual', false);

INSERT INTO gearbox_type (name, isdeleted)
VALUES ('Automatic', false);

INSERT INTO car (id_user, advertised, allowedkm, cdw, children_seats, city, country , km, registration_plate, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES (1, 1, '100', 1, '2', 'Tokyo', 'Japan', '19000', 'BG4561-TB', 'Tokugawa Blwd.', '1600', 
( SELECT id_car_brand FROM car_brand WHERE name ='Mitsubishi' ),
( SELECT id_car_class FROM car_class WHERE name ='SUV' ), 
( SELECT id_car_model FROM car_model WHERE name ='Pajero' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Gasoline' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Manual' ));

INSERT INTO car (id_user, advertised, allowedkm, cdw, children_seats, city, country , km, registration_plate, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES (1, 1, '120', 0, '1', 'Satsuma', 'Japan', '4000','IN12345-CZ',  'Emperor Meiji Str.', '20', 
( SELECT id_car_brand FROM car_brand WHERE name ='Honda' ),
( SELECT id_car_class FROM car_class WHERE name ='Sedan' ), 
( SELECT id_car_model FROM car_model WHERE name ='Accord' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Diesel' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Automatic' ));

INSERT INTO car (id_user, advertised, allowedkm, cdw, children_seats, city, country , km, registration_plate, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES (1, 1, '100', 1, '2', 'Yokohama', 'Japan', '109000', 'NS12345-AB', 'Shigurui Str.', '101', 
( SELECT id_car_brand FROM car_brand WHERE name ='Toyota' ),
( SELECT id_car_class FROM car_class WHERE name ='Sedan' ), 
( SELECT id_car_model FROM car_model WHERE name ='Corolla' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Gasoline' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Manual' ));

INSERT INTO car (id_user, advertised, allowedkm, cdw, children_seats, city, country , km,  registration_plate, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES (1, 0, '200', 0, '0', 'NeoTokyo', 'Japan', '200000', 'BG12345-ZA', 'Belgrade Str.', '1389', 
( SELECT id_car_brand FROM car_brand WHERE name ='Suzuki' ),
( SELECT id_car_class FROM car_class WHERE name ='Convertible' ), 
( SELECT id_car_model FROM car_model WHERE name ='Samurai' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='TNG' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Manual' ));

INSERT INTO car (id_user, advertised, allowedkm, cdw, children_seats, city, country , km,  registration_plate, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES (3, 0, '130', 1, '1', 'Nagoya', 'Japan', '3000', 'BG2589-AC','ShinShin Ave.', '203', 
( SELECT id_car_brand FROM car_brand WHERE name ='Suzuki' ),
( SELECT id_car_class FROM car_class WHERE name ='Sport' ), 
( SELECT id_car_model FROM car_model WHERE name ='Vitara' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Gasoline' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Automatic' ));

INSERT INTO car (id_user, advertised, allowedkm, cdw, children_seats, city, country , km, registration_plate, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES (4, 0, '300', 0, '0', 'Osaka', 'Japan', '999', 'BG8569-DS', 'DriftKings Str.', '2000', 
( SELECT id_car_brand FROM car_brand WHERE name ='Mitsubishi' ),
( SELECT id_car_class FROM car_class WHERE name ='Sport' ), 
( SELECT id_car_model FROM car_model WHERE name ='Evo' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Gasoline' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Manual' ));