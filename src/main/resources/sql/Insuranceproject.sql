create database examp_db;

use examp_db;

create table customer(
id bigint auto_increment not null,
first_name varchar(100)not null,
last_name varchar(90)not null,
email varchar(70)not null,
phone bigint,
gender varchar(30)not null,
last_four_ssn varchar(35) unique,
dob varchar (45),
primary key (id)
);

create table policy(
id bigint auto_increment not null,
type varchar (80) not null,
policy_number varchar(50) not null unique,
start_date varchar(100)not null,
expiration_date varchar(60)not null,
price varchar (80),
customer_id bigint,
primary key(id),
foreign key(customer_id) references customer(id)
);

create table address(
id bigint auto_increment not null,
street1 varchar(100)not null,
street2 varchar(100),
city varchar(80)not null,
state varchar(60)not null,
zipcode bigint not null,
type varchar(50),
customer_id bigint,
primary key(id),
foreign key(customer_id) references customer(id)
);

create table covered_driver(
id bigint auto_increment not null,
first_name varchar(60)not null,
last_name varchar(60)not null,
licence_No varchar(60) unique,
licence_state varchar(60)not null,
is_active boolean not null default true,
policy_id bigint,
primary key(id),
foreign key(policy_id) references policy(id)
);
 create table covered_vehicle(
 id bigint auto_increment not null,
 make varchar(80) not null,
 model varchar(70) not null,
 year bigint not null,
 color varchar(70),
 vin varchar(70) not null unique,
 is_active boolean not null default true,
 policy_id bigint,
 primary key(id),
 foreign key (policy_id) references policy(id)
 );
 
 select * from customer;
 select * from address;
 select * from policy;
 select * from covered_vehicle;
 

