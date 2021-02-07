drop database if exists db_ams;
create database db_ams;
use db_ams;


create table address
(
    id      int          not null
        primary key,
    city    varchar(255) null,
    country varchar(255) null
);

create table company
(
    id         int          not null
        primary key,
    found_date datetime     null,
    name       varchar(255) null
);

create table passenger
(
    id         int auto_increment
        primary key,
    name       varchar(255) null,
    phone      varchar(255) null,
    address_id int          null,
    constraint FKa5eqvs47wimov9dlbebmtmyog
        foreign key (address_id) references address (id)
);

create table trip
(
    trip_number int          not null
        primary key,
    time_in     date         null,
    time_out    date         null,
    town_from   varchar(255) null,
    town_to     varchar(255) null,
    company_id  int          null,
    constraint FKd8xxxfscmdntnmtoqu3kuqbm3
        foreign key (company_id) references company (id)
);

create table passengers_trip
(
    trip_id      int not null,
    passenger_id int not null,
    primary key (passenger_id, trip_id),
    constraint FK6lirlvjmug2tbj653ilx090j7
        foreign key (passenger_id) references passenger (id),
    constraint FK75dokeevfo7i8d9j2rd03cjgt
        foreign key (trip_id) references trip (trip_number)
);

show tables;