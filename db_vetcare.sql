CREATE DATABASE db_vetcare;
USE db_vetcare;

CREATE TABLE owners (
id int primary key,
identification_type varchar(25),
document_number varchar(25) UNIQUE,
full_name varchar (75),
phone varchar (25),
email varchar (40) UNIQUE,
addres varchar (100),
state boolean,
registered_date date
);

CREATE TABLE pets (
id int primary key,
owner_id int,
foreign key (owner_id) references owners (id),
name varchar (25),
species varchar (25),
breed varchar (25),
sex varchar (25),
birth_date date,
weigth double,
state boolean,
registered_date date
);

CREATE TABLE veterinarians(
id int primary key,
document_number varchar (25) UNIQUE,
full_name varchar (75),
lisence_number varchar (25) UNIQUE,
specialty varchar (50),
phone varchar (25),
email varchar (40) UNIQUE,
state boolean
);

CREATE TABLE appointments (
id int primary key,
pet_id int,
foreign key (pet_id) references pets (id),
veterinarian_id int,
foreign key (veterinarian_id) references veterinarians (id),
date date,
time time,
reason varchar (100),
status varchar (25),
created_date date
);

CREATE TABLE medical_records(
id int primary key,
appointment_id int,
foreign key (appointment_id) references appointments (id),
pet_id int,
foreign key (pet_id) references pets (id),
veterinarian_id int,
foreign key (veterinarian_id) references veterinarians (id),
symptoms varchar (100),
diagnosis varchar (100),
treatment varchar (100),
observations varchar (100),
attended_date date,
status varchar (25)
);

CREATE TABLE medicines (
id int primary key,
medicine_code varchar (30) UNIQUE,
medicine_name varchar (30),
presentation varchar (25),
laboratory varchar (45),
aviable_quantity int,
minimum_quantity int,
unit_price double,
state boolean,
registered_date date
);

CREATE TABLE medical_record_medicines (
id int primary key,
medical_record_id int,
foreign key (medical_record_id) references medical_records (id),
medicine_id int,
foreign key (medicine_id) references medicines (id),
quantity_used int
);

CREATE TABLE users (
id int primary key,
username varchar (25) UNIQUE,
password varchar (30),
role varchar (40),
state boolean
);