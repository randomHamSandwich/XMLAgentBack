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
 