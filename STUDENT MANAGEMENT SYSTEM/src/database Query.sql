create database studentmanagementsystem;
use studentmanagementsystem;
create table studentdata(
name varchar(50) ,
enrollmenno varchar(15) primary key,
mobileno mediumtext ,
fathersmobileno mediumtext ,
fathersname varchar(50) ,
dob tinytext ,
program tinytext ,
branch tinytext ,
gender tinytext
);


use studentmanagementsystem;
insert into studentdata (name, enrollmenno, mobileno, fathersmobileno, fathersname, dob, program, branch, gender)
values 
 ('Shivya', '23100CLG006', 9780229409, 7302314432, 'Raman KUMAR ', '11-01-2003', 'B TECH', 'C.E', 'male'),
('RAKSHITA', '23100CLG004', '8902467580', '89024675889', 'SHYAM SINGH ', '19-11-2002', 'B TECH', 'CSE', 'female'),
('NITISH SHARMA ', '23100CLG005', '9780229407', '9780229408', 'NEELAM KUMAR ', '19-09-2001', 'M TECH', 'OTHER', 'male'),
('Meenakshi ', '23100CLG007', '9463058421', '7302314432', 'Tirath ram', '21-06-2003', 'DEPLOMA', 'OTHER', 'female'),
('Kumari Ankita Yadav', '23100CLG008', '7889578375', '7889578875', 'Neerpal', '08-08-2000', 'B TECH', 'M.E', 'female'),
('JYOTI KUMARI ', '23100CLG010', '76176744444', '88525232322', 'Mr. RAMAN PRASAD', '21-05-2002', 'BCA', 'CSE', 'female'),
('harsiddhi kushwah', '23100CLG011', '7856743212', '9078452312', 'ganesh kushwah', '01-03-2003', 'BCA', 'E.C', 'female'),
('Darshika Gupta', '23100CLG003', '1478536920', '7841230695', 'Kush Gupta', '15-10-2002', 'DEPLOMA', 'E.C', 'female'),
('Anurup verma', '23100CLG002', '7896541230', '3698521470', 'Shytam varma', '14-06-2003', 'B TECH', 'M.E', 'male'),
('Aman Sharma', '23100CLG001', '1234567890', '1245789630', 'raghav Sharma', '08-01-2003', 'BCA', 'E.E', 'male'),
(' Anushika Sharma ', '23100CLG009', '7986361432', '8986361432', 'Kanwal Kishore', '05-03-2004', 'B TECH', 'M.E', 'female')
;


select * from studentdata ; 

