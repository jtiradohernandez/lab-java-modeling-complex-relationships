drop schema nurse_association;
create schema nurse_association;
use nurse_association;


create table association(
    id int AUTO_INCREMENT not null,
    name varchar(255) not null,
    primary key(id)
);

CREATE TABLE member(
	member_id int not null auto_increment,
    name varchar(255) not null,
    member_status enum('ACTIVE','LAPSED'),
    renewal_date date,
    primary key(member_id)
);

create table chapter(
    id int not null auto_increment,
    name varchar(255) not null,
    district varchar(255) not null,
    president_id int not null,
    association_id int not null,
    foreign key(president_id) references member(member_id),
    foreign key(association_id) references association(id),
    primary key(id)
);