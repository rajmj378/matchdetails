create table matches(
id bigint not null auto_increment,
match_date datetime not null,
home_team_id bigint not null,
away_team_id bigint not null,
location varchar(100) not null,
primary key(id),
foreign key (home_team_id) references teams(id),
foreign key (away_team_id) references teams(id));