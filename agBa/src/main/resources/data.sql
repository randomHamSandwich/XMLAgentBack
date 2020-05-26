insert into roles (role_name) values ('END_USER');
insert into roles (role_name) values ('END_USER_FORBIDDEN');
insert into roles (role_name) values ('END_USER_LIMITED_ACCESS');
insert into roles (role_name) values ('ADMIN');
insert into roles (role_name) values ('AGENT');

insert into user (user_type, phone_number,street_number, country, email, city, password, status, street) 
values ('END_USER', '111111111111', '15', 'Srbija', 'peraspringuser19@gmail.com', 'Novi Sad',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'ACTIVE', 'Gogoljeva');
 insert into user_role(id_role, id_user) values ('1','1');

insert into user (user_type, phone_number,street_number, country, email, city, password, status, street) 
values ('ADMIN', '909090909090909090', '15', 'Srbija', 'admin@gmail.com', 'Novi Sad',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'ACTIVE', 'Cara Dusana');
 insert into user_role(id_role, id_user) values ('4','2');

insert into user (user_type, phone_number,street_number, country, email, city, password, status, street) 
values ('END_USER', '111111111111', '21', 'Srbija', 'mirjanaspringuser19@gmail.com', 'Beograd',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'ACTIVE', 'Golubinacka');
 insert into user_role(id_role, id_user) values ('1','3');

insert into user (user_type, phone_number,street_number, country, email, city, password, status, street) 
values ('END_USER', '909090909090909090', '64', 'Srbija', 'lugaspring@gmail.com ', 'Kikinda',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'ACTIVE', 'Zlatiborska');
 insert into user_role(id_role, id_user) values ('1','4');
 
INSERT INTO car_brand (name)
VALUES ('Mitsubishi');

INSERT INTO car_brand (name)
VALUES ('Suzuki');

INSERT INTO car_brand (name)
VALUES ('Toyota');

INSERT INTO car_brand (name)
VALUES ('Honda');

INSERT INTO car_class (name)
VALUES ('Sedan');

INSERT INTO car_class (name)
VALUES ('SUV');

INSERT INTO car_class (name)
VALUES ('Limousine');

INSERT INTO car_class (name)
VALUES ('Convertible');

INSERT INTO car_class (name)
VALUES ('Sport');

INSERT INTO car_model (name)
VALUES ('Corolla');

INSERT INTO car_model (name)
VALUES ('Yaris');

INSERT INTO car_model (name)
VALUES ('Samurai');

INSERT INTO car_model (name)
VALUES ('Vitara');

INSERT INTO car_model (name)
VALUES ('Pajero');

INSERT INTO car_model (name)
VALUES ('Accord');

INSERT INTO car_model (name)
VALUES ('Evo');

INSERT INTO fuel_type (name)
VALUES('TNG');

INSERT INTO fuel_type (name)
VALUES('Gasoline');

INSERT INTO fuel_type (name)
VALUES('Diesel');

INSERT INTO fuel_type (name)
VALUES('Electric');

INSERT INTO gearbox_type (name)
VALUES ('Manual');

INSERT INTO gearbox_type (name)
VALUES ('Automatic');

INSERT INTO car (allowedkm, cdw, children_seats, city, country , km, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES ('100', 1, '2', 'Tokyo', 'Japan', '19000', 'Tokugawa Blwd.', '1600', 
( SELECT id_car_brand FROM car_brand WHERE name ='Mitsubishi' ),
( SELECT id_car_class FROM car_class WHERE name ='SUV' ), 
( SELECT id_car_model FROM car_model WHERE name ='Pajero' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Gasoline' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Manual' ));

INSERT INTO car (allowedkm, cdw, children_seats, city, country , km, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES ('120', 0, '1', 'Satsuma', 'Japan', '4000', 'Emperor Meiji Str.', '20', 
( SELECT id_car_brand FROM car_brand WHERE name ='Honda' ),
( SELECT id_car_class FROM car_class WHERE name ='Sedan' ), 
( SELECT id_car_model FROM car_model WHERE name ='Accord' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Diesel' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Automatic' ));

INSERT INTO car (allowedkm, cdw, children_seats, city, country , km, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES ('100', 1, '2', 'Yokohama', 'Japan', '109000', 'Shigurui Str.', '101', 
( SELECT id_car_brand FROM car_brand WHERE name ='Toyota' ),
( SELECT id_car_class FROM car_class WHERE name ='Sedan' ), 
( SELECT id_car_model FROM car_model WHERE name ='Corolla' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Gasoline' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Manual' ));

INSERT INTO car (allowedkm, cdw, children_seats, city, country , km, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES ('200', 0, '0', 'NeoTokyo', 'Japan', '200000', 'Belgrade Str.', '1389', 
( SELECT id_car_brand FROM car_brand WHERE name ='Suzuki' ),
( SELECT id_car_class FROM car_class WHERE name ='Convertible' ), 
( SELECT id_car_model FROM car_model WHERE name ='Samurai' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='TNG' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Manual' ));

INSERT INTO car (allowedkm, cdw, children_seats, city, country , km, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES ('130', 1, '1', 'Nagoya', 'Japan', '3000', 'ShinShin Ave.', '203', 
( SELECT id_car_brand FROM car_brand WHERE name ='Suzuki' ),
( SELECT id_car_class FROM car_class WHERE name ='Sport' ), 
( SELECT id_car_model FROM car_model WHERE name ='Vitara' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Gasoline' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Automatic' ));

INSERT INTO car (allowedkm, cdw, children_seats, city, country , km, street, street_number, id_car_brand, id_car_class, id_car_model, id_fuel_type, id_gearbox_type)
VALUES ('300', 0, '0', 'Osaka', 'Japan', '999', 'DriftKings Str.', '2000', 
( SELECT id_car_brand FROM car_brand WHERE name ='Mitsubishi' ),
( SELECT id_car_class FROM car_class WHERE name ='Sport' ), 
( SELECT id_car_model FROM car_model WHERE name ='Evo' ), 
( SELECT id_fuel_type FROM fuel_type WHERE name ='Gasoline' ),
( SELECT id_gearbox_type FROM gearbox_type WHERE name ='Manual' ));


