create table players(
id bigint not null auto_increment,
name varchar(50) not null,
position varchar(25) not null,
age int,
team_id bigint,
primary key(id),
foreign key (team_id) references teams(id));