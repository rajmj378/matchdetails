create schema football_leage_db;

create table teams(
id bigint not null auto_increment,
name varchar(50) not null,
country varchar(25) not null,
manager varchar(100),
logo_img varchar(100),
primary key(id));

alter table teams add column created_at datetime not null;

alter table teams add column updated_at datetime not null;