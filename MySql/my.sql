#DDL -create, alter, drop
#create  ----database
#create database dbname;

create database ecart;

use ecart;

create table products(
prodId int primary key,
prodName varchar(40) not null unique,
prodPrice double not null,
brand char(10),
prodDesc varchar(50),
prodCategory char(15) not null,
prodAval boolean,
prodManfDate date not null
);

create table customers(
custId int primary key,
custName varchar(20) not null,
custSurname varchar(30),
custPhone bigint not null unique,
custEmail varchar(20) not null unique,
custAddr varchar(50)
);

#drop table
#drop table customers;

#drop database
#drop database ecart;

#alter ---an changes with existing structure
#add(add an new col), modify(change datatypes,size,contrints), 
#drop(remove col), rename(col,table)

#alter table tbname add column datatype constraints
alter table customers add custdob date not null;

#alter table tbname modify colnaame?
#modifying datatype size of email
alter table customers modify custEmail varchar(25) not null unique;

#modifying constraints of addr
alter table customers modify custAddr varchar(30) not null;

#alter table tbname drop column colname
alter table customers drop column custdob;

#alter table tbname rename
alter table customers rename column custName to custFirstName;

#alter table tbname rename to newtbname (table)
alter table products rename column prodName to productName;

alter table customers add custdob date;


#DML --- Manipulation
#insert, update, delete
#insert into tbname(cols) values();  (syntax)

insert into products(prodId, prodName, prodPrice, brand, 
prodDesc, prodcategory, prodAval, prodManfDate) 
values(11,'XYZ M2', 50000, 'OnePlus', 'Smart phone',
'Mobile Phone', '1', '2023-01-30');

#inserting multiple rows
insert into products(prodId, prodName, prodPrice, brand, 
prodDesc, prodcategory, prodAval, prodManfDate) 
values(12, 'Boat Rocker', 1000, 'Boat', 'Wireless & smart', 
'Accessories', 1, '2020-01-25'),
(13, 'X2 Smart Tv', 67000, 'sony', 'LED Smart TV', 'Television',
1, '2021-12-31'),
(14, 'M2 LG AC', 35000, 'LG', 'latest ac comfart', 
'Home Appliances', 1, '2023-10-12'),
(15, 'intel i7 HP', 68000, 'HP', 'core latest', 'Laptop', 0, 
'2020-12-20');

#inserting multiple rows in customers

insert into customers(custId, custName, custSurname, custPhone,
custEmail,custAddr,custdob)
values(101, 'Nikita', 'Chavan', 8691987101, 'nikita12@gmail.com',
'Dombivali', '1999-09-08');

insert into customers(custId, custName, custSurname, custPhone,
custEmail,custAddr,custdob)
values(102, 'Neha', 'Badhe', 7896541230, 'neha12@gmail.com',
'Kalyan', '1998-07-01'),
(103, 'Dhiraj', 'Jadhav', 7896545630, 'dhiraj12@gmail.com',
'Kurla', '2003-07-16'),
(104, 'Sudhir', 'Chavan', 1236547897, 'sudhir@gmail.com',
'vashi', '2001-01-27');

#update tbname set colname ='value' where colname; (syntax)
update customers set custAddr='airoli' where custId=104;
update products set prodPrice= 40000 where prodId=14;

#delete from tbname where colname; (syntax)
delete from products where prodId=15;

#DQL/DRL - showing /fetch the data or resultset
#Select colname/* from tbname;  (syntax)

#showing all details from customers
select * from customers;

#showing only customers id, name, phone details
select custId, custName, custPhone from customers;

#showing all products details 
select * from products;

#fetch customers detils whose name is nikita
select * from customers where custName='Nikita';

#fetch customers details who stay in kurla
select custName, custPhone, custEmail from customers 
where custAddr='kurla';

#Operators
#show product details of price 10k
select * from products where prodPrice = 1000;

#show product details of price > 40k and price=40 & greater
select * from products where prodPrice >40000;
select * from products where prodPrice >= 40000;

select * from products where prodPrice != 40000;

#select product details of mobile phone & price is 50k
select * from products where prodcategory='mobile phone'
and prodPrice=50000;

#selectproduct details of mobile phone or proce is 50k
select * from products where prodcategory='television'
or prodPrice=50000;

#fetch customer details who do not stay in mumbai
select * from customers where custAdde !='mumbai';
#or
select * from customers where custAdde <>'mumbai';

#Give discount 5% on product price
select prodName, prodPrice, prodPrice-(prodPrice*0.05)
from products;

#Alice (as) gives temporary name
select prodName, prodPrice, prodPrice-(prodPrice*0.05) as
'discountPrice' from products;

#give an delivery charges on product of Rs.500
select prodName, prodPrice, prodPrice+500 as 'totalAmount'
from products;

#add an 18% tax on products
select prodName, prodPrice, prodPrice*0.18 as 'TaxAmt'
from products;

#total amount
select prodName, prodPrice, prodPrice*0.18 as 'TaxAmt',
prodPrice + (prodPrice*0.18) as 'payable amount'
from products; 

#order by -- sorting in asc or desc
select * from customers order by custAddr;
select * from customers order by custAddr desc;

#range on product price
select * from products where prodPrice between 20000 and
50000;

select * from customers where custdob between 
'2000-01-01' and '2003-12-31';

#list --- instead of multiple or 
select * from products where prodprice in(10000,20000,30000);

#group by -- collection of similar things
select prodcategory from products group by prodCategory;

#Aggregate funtion - count, sum, min, max, avg
#count, sum of product according to category
select prodcategory, count(prodId) from products
group by prodCategory;

select prodcategory, count(prodId), sum(prodPrice) from products
group by prodCategory;

select prodCategory, count(prodId), sum(prodPrice), max(prodPrice),
min(prodPrice) from products group by prodCategory;

#count of total products
select count(prodId) from products;

#max price of products
select max(prodPrice) from products;

create table orders(
oid int primary key,
prodName varchar(30),
totalPrice double,
orderDate date,
orderStatus varchar(20),
customerId int);

#add foreign key
alter table orders ADD Foreign Key(customerId)
references customers(custId);

insert into orders values(1, 'XYZ', 50000, '2023-05-01', 
'delivered', 103),
(2, 'Boat Rockers', 800, '2023-07-23', 'in process', 101);

#Joins
#select cols from table1 joiningtype table2 condition; (syntax)

#fetch orderdetails of customer who placed orders
select custFirstName, custPhone

/*-------------------------------------------------------*/

use ecart;

create table Student
(sid int primary key auto_increment,
sname varchar(20) not null,
saddr varchar(50),
semail varchar(25) not null unique,
sphone bigint not null unique,
seduc varchar(15));

select * from Student;

create table book(
bid int primary key auto_increment,
bname varchar(30),
bauthor varchar(30),
bprice int
);



