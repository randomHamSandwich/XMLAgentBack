insert into roles (naziv_role) values ('KORISNIK');
insert into roles (naziv_role) values ('KORISNIK_ZABRANJEN');
insert into roles (naziv_role) values ('KORISNIK_OGRANI_PRISTUP');
insert into roles (naziv_role) values ('ADMIN');
insert into roles (naziv_role) values ('AGENT');



insert into korisnik (tip_korisnika, broj_telefona,broj_ulice, drzava, email, grad, lozinka, status, ulica) 
values ('KRAJNI_KORISNIK', '111111111111', '15', 'Srbija', 'peraspringuser19@gmail.com', 'Novi Sad',
 '$2a$10$./yRHDMtr84Dr8w5Zr9Y/eaG3MPVzDmpH.uL3NCMmC/6Syy8RWCoa', 'ACTIVE', 'Gogoljeva');
 
  insert into korisnik_role(id_rola, id_korisnik) values ('1','1');

