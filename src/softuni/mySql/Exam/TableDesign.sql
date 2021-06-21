create table drivers (
id int primary key auto_increment,
first_name varchar(30) not null,
last_name varchar(30) not null,
age int not null,
rating float default 5.5
);

create table categories (
id int primary key auto_increment,
`name` varchar(10) not null
);

create table cars (
id int primary key auto_increment,
make varchar(20) not null,
model varchar(20),
year int not null default 0,
mileage int default 0,
`condition` char(1) not null,
category_id int not null,
constraint fk_cars_categories
foreign key (category_id)
references categories (id)
);

create table cars_drivers (
car_id int not null,
driver_id int not null,
primary key (car_id, driver_id),
constraint fk_cars_drivers_cars
foreign key (car_id)
references cars (id),
constraint fk_cars_drivers_driver
foreign key (driver_id)
references drivers (id)
);

create table addresses (
id int primary key auto_increment,
`name` varchar(100) not null
);

create table clients (
id int primary key auto_increment,
full_name varchar(50) not null,
phone_number varchar(20) not null
);

create table courses (
id int primary key auto_increment,
from_address_id int not null,
start datetime not null,
bill decimal(10, 2) default 10,
car_id int not null,
client_id int not null,
constraint fk_courses_clients
foreign key (client_id)
references clients (id),
constraint fk_courses_addresses
foreign key (from_address_id)
references addresses (id),
constraint fk_courses_cars
foreign key (car_id)
references cars (id)
);