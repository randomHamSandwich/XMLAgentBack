insert into roles (role_name) values ('END_USER');
insert into roles (role_name) values ('END_USER_FORBIDDEN');
insert into roles (role_name) values ('END_USER_LIMITED_ACCESS');
insert into roles (role_name) values ('ADMIN');
insert into roles (role_name) values ('AGENT');


insert into user (user_type, phone_number,street_number, country, email, city, password, status, street, isdeleted)
values ('END_USER', '111111111111', '15', 'Srbija', 'peraspringuser19@gmail.com', 'Novi Sad',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'ACTIVE', 'Gogoljeva', false);
 insert into user_role(id_role, id_user) values ('1','1');

insert into user (user_type, phone_number,street_number, country, email, city, password, status, street, isdeleted)
values ('ADMIN', '909090909090909090', '15', 'Srbija', 'admin@gmail.com', 'Novi Sad',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'ACTIVE', 'Cara Dusana', false);
 insert into user_role(id_role, id_user) values ('4','2');

insert into user (user_type, phone_number,street_number, country, email, city, password, status, street, isdeleted)
values ('END_USER', '111111111111', '21', 'Srbija', 'mirjanaspringuser19@gmail.com', 'Beograd',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'ACTIVE', 'Golubinacka', false);
 insert into user_role(id_role, id_user) values ('1','3');

insert into user (user_type, phone_number,street_number, country, email, city, password, status, street, isdeleted)
values ('END_USER', '909090909090909090', '64', 'Srbija', 'lugaspring@gmail.com ', 'Kikinda',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'ACTIVE', 'Zlatiborska', false);
 insert into user_role(id_role, id_user) values ('1','4');
 
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

INSERT INTO car (advertised, allowedkm, cdw, children_seats, city, country , km, registration_plate, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES (1, '100', 1, '2', 'Tokyo', 'Japan', '19000', 'BG4561-TB', 'Tokugawa Blwd.', '1600', 
( SELECT id_car_brand FROM car_brand WHERE name ='Mitsubishi' ),
( SELECT id_car_class FROM car_class WHERE name ='SUV' ), 
( SELECT id_car_model FROM car_model WHERE name ='Pajero' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Gasoline' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Manual' ));

INSERT INTO car (advertised, allowedkm, cdw, children_seats, city, country , km, registration_plate, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES (1, '120', 0, '1', 'Satsuma', 'Japan', '4000','IN12345-CZ',  'Emperor Meiji Str.', '20', 
( SELECT id_car_brand FROM car_brand WHERE name ='Honda' ),
( SELECT id_car_class FROM car_class WHERE name ='Sedan' ), 
( SELECT id_car_model FROM car_model WHERE name ='Accord' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Diesel' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Automatic' ));

INSERT INTO car (advertised, allowedkm, cdw, children_seats, city, country , km, registration_plate, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES (1, '100', 1, '2', 'Yokohama', 'Japan', '109000', 'NS12345-AB', 'Shigurui Str.', '101', 
( SELECT id_car_brand FROM car_brand WHERE name ='Toyota' ),
( SELECT id_car_class FROM car_class WHERE name ='Sedan' ), 
( SELECT id_car_model FROM car_model WHERE name ='Corolla' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Gasoline' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Manual' ));

INSERT INTO car (advertised, allowedkm, cdw, children_seats, city, country , km,  registration_plate, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES (0, '200', 0, '0', 'NeoTokyo', 'Japan', '200000', 'BG12345-ZA', 'Belgrade Str.', '1389', 
( SELECT id_car_brand FROM car_brand WHERE name ='Suzuki' ),
( SELECT id_car_class FROM car_class WHERE name ='Convertible' ), 
( SELECT id_car_model FROM car_model WHERE name ='Samurai' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='TNG' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Manual' ));

INSERT INTO car (advertised, allowedkm, cdw, children_seats, city, country , km,  registration_plate, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES (0, '130', 1, '1', 'Nagoya', 'Japan', '3000', 'BG2589-AC','ShinShin Ave.', '203', 
( SELECT id_car_brand FROM car_brand WHERE name ='Suzuki' ),
( SELECT id_car_class FROM car_class WHERE name ='Sport' ), 
( SELECT id_car_model FROM car_model WHERE name ='Vitara' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Gasoline' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Automatic' ));

INSERT INTO car (advertised, allowedkm, cdw, children_seats, city, country , km, registration_plate, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES (0, '300', 0, '0', 'Osaka', 'Japan', '999', 'BG8569-DS', 'DriftKings Str.', '2000', 
( SELECT id_car_brand FROM car_brand WHERE name ='Mitsubishi' ),
( SELECT id_car_class FROM car_class WHERE name ='Sport' ), 
( SELECT id_car_model FROM car_model WHERE name ='Evo' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Gasoline' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Manual' ));

INSERT INTO pricelist(price_forkm, price_for_one_day, id_discount, id_user) VALUES (10, 12, 1, 1);
INSERT INTO pricelist(price_forkm, price_for_one_day, id_discount, id_user) VALUES (12, 11, 2, 2);
INSERT INTO pricelist(price_forkm, price_for_one_day, id_discount, id_user) VALUES (14, 12, 1, 1);

INSERT INTO ad(end_date, start_date, id_car, id_user, id_price_list) VALUES ('2025-01-11 01:00:00', '2020-06-14 04:00:00', 1, 1, 1);
INSERT INTO ad(end_date, start_date, id_car, id_user, id_price_list) VALUES ('2024-02-12 02:00:00', '2020-07-15 05:00:00', 3, 3, 1);
INSERT INTO ad(end_date, start_date, id_car, id_user, id_price_list) VALUES ('2023-03-13 03:00:00', '2020-08-16 06:00:00', 2, 1, 1);

INSERT INTO discount(discount, for_more_thanxdays, version, id_user) VALUES (5, 15, 0, 1);
INSERT INTO discount(discount, for_more_thanxdays, version, id_user) VALUES (10, 30, 0, 2);
INSERT INTO discount(discount, for_more_thanxdays, version, id_user) VALUES (7, 18, 0, 1);

insert into images (name, image_loc)
values ('mitsubishi_pajero', '../agBa/images/mitsubishi-pajero.jpg');

insert into images (name, image_loc)
values ('toyota_corrola', '../agBa/images/toyota-corrola.jpg');

