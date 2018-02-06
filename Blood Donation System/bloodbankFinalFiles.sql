use  mydb;
show tables;

select * from bloodbank;
insert into Hospital (HospitalID, HospitalName,Address,ContactNo,email) values (1,'Lilavati','Bandra',1234567890,'123@gmail.com');
insert into Hospital (HospitalID, HospitalName,Address,ContactNo,email) values (2,'Hinduja','Mahim',1234567880,'1234@gmail.com');
insert into Hospital (HospitalID, HospitalName,Address,ContactNo,email) values (3,'Tata','Bandra',123456770,'123456@gmail.com');



insert into driver (DriverID, DriverName,ContactNo) values (1,'Jay',1234467890);
insert into driver (DriverID, DriverName,ContactNo) values (2,'Aj',1233467890);
insert into driver (DriverID, DriverName,ContactNo) values (3,'Jerin',1244467890);



insert into request (RequestID,RequestDate,Quantity_Requested,Blood_Type_Requested,Hospital_HospitalID) values (1,'2017-10-02',10,'B+',1);
insert into request (RequestID,RequestDate,Quantity_Requested,Blood_Type_Requested,Hospital_HospitalID) values (2,'2017-10-03',10,'A+',2);
insert into request (RequestID,RequestDate,Quantity_Requested,Blood_Type_Requested,Hospital_HospitalID) values (3,'2017-10-04',10,'A+',1);
insert into request (RequestID,RequestDate,Quantity_Requested,Blood_Type_Requested,Hospital_HospitalID) values (4,'2017-10-04',10,'A+',3);
insert into request (RequestID,RequestDate,Quantity_Requested,Blood_Type_Requested,Hospital_HospitalID) values (5,'2017-10-02',10,'B+',1);
insert into request (RequestID,RequestDate,Quantity_Requested,Blood_Type_Requested,Hospital_HospitalID) values (6,'2017-10-03',10,'A+',2);
insert into request (RequestID,RequestDate,Quantity_Requested,Blood_Type_Requested,Hospital_HospitalID) values (7,'2017-10-04',10,'A+',1);
insert into request (RequestID,RequestDate,Quantity_Requested,Blood_Type_Requested,Hospital_HospitalID) values (8,'2017-10-04',10,'A+',3);

select * from donorhealthreport;

insert into donorhealthreport(ReportID,BloodType,amount,quantity,DonatedDate) values(1,'B+',100,2,'2017-4-02');
insert into donorhealthreport(ReportID,BloodType,amount,quantity,DonatedDate) values(2,'B+',100,1.5,'2017-4-03');
insert into donorhealthreport(ReportID,BloodType,amount,quantity,DonatedDate) values(3,'A+',100,2,'2017-4-02');
insert into donorhealthreport(ReportID,BloodType,amount,quantity,DonatedDate) values(4,'A+',100,1,'2017-4-08');
insert into donorhealthreport(ReportID,BloodType,amount,quantity,DonatedDate) values(5,'O+',100,2,'2017-4-10');
insert into donorhealthreport(ReportID,BloodType,amount,quantity,DonatedDate) values(6,'O+',100,1,'2017-4-04');
insert into donorhealthreport(ReportID,BloodType,amount,quantity,DonatedDate) values(7,'B+',100,2,'2017-4-02');
insert into donorhealthreport values(8,'A+',100,2,'2017-4-08',2);

drop trigger donorhealthreport_AFTER_INSERT;
insert into receptionist (ReceptionistID, ReceptionistName,address,contactNo,email) values (1,'Priya','Malad',2121212121,'priya@gmail.com');
insert into receptionist (ReceptionistID, ReceptionistName,address,contactNo,email) values (2,'Khush','Malad',0101010110,'khush@gmail.com');
insert into receptionist (ReceptionistID, ReceptionistName,address,contactNo,email) values (3,'Aditi','Malad',2090909090,'aditi@gmail.com');

insert into doctor (DoctorID, DoctorName,address,Qualifications,Receptionist_ReceptionistID) values (1,'Gaurav','Andheri','M.B.B.S',1);
insert into doctor (DoctorID, DoctorName,address,Qualifications,Receptionist_ReceptionistID) values (2,'Rohit','Dadar','M.B.B.S',2);
insert into doctor (DoctorID, DoctorName,address,Qualifications,Receptionist_ReceptionistID) values (3,'Ashish','Malad','M.B.B.S',3);


insert into nurse  values (1,'Richa','Kandivali',2121212121,'richa@gmail.com',1,1);
insert into nurse  values (2,'Saloni','Borivali',0101010110,'saloni@gmail.com',2,2);
insert into nurse  values (3,'Mahek','Malad',2090909090,'mahek@gmail.com',3,3);

insert into bloodshipment  values (1,'2017-10-22',10,1);
insert into bloodshipment  values (2,'2017-10-15',10,2);
insert into bloodshipment  values (3,'2017-10-20',10,3);

insert into bloodbank  values (1,'TakeBlood','Kandivali',2121212121,'takeblood@gmail.com',1,1,1);
insert into bloodbank  values (2,'CityBloodBank','Borivali',0101010110,'takeblood@gmail.com',2,2,2);
insert into bloodbank  values (3,'TusharBloodank','Malad',2090909090,'takeblood@gmail.com',4,3,3);
insert into bloodbank  values (4,'AshishBloodBank','Kandivali',2121212121,'takeblood@gmail.com',1,1,1);
insert into bloodbank  values (6,'AJBloodBank','Borivali',0101010110,'takeblood@gmail.com',2,2,2);
insert into bloodbank  values (7,'SameerBloodBank','Malad',2090909090,'takeblood@gmail.com',4,3,3);
select * from bloodinventory;

 insert into bloodinventory  (bloodinventory.BloodType)  value ('B+') ;
insert into bloodinventory (bloodinventory.BloodType) value ('A+');
insert into bloodinventory (bloodinventory.BloodType) value ('O+');

insert into labtechnician  values (1,'Ruchir','Borivali',1111111111,'ruchir@gmail.com',1);
insert into labtechnician  values (2,'Akshay','Malad',222222222,'akshay@gmail.com',2);
insert into labtechnician  values (3,'Brian','Kandivali',33333333,'akshay@gmail.com',3);

insert into nurse_has_labtechnician values(1,1);
insert into nurse_has_labtechnician values(2,2);
insert into nurse_has_labtechnician values(3,3);

insert into blooddonationcamp values (1,'HealthCare Camp',1,1,1,1);
insert into blooddonationcamp values (2,'BloodCare Camp',2,2,2,2);
insert into blooddonationcamp values (3,'CityBlood Camp',3,4,3,3);

insert into donor values (1,'Hiren','Malad',982133636,'hiren@gmail.com',1,1,1,1);
insert into donor values (2,'Darshan','Borivali',808262844,'darshan@gmail.com',2,1,1,1);
insert into donor values (3,'Ashok','Kandivali',887948439,'ashok@gmail.com',3,1,1,1);

insert into donor values (4,'Gaurang','Malad',765432198,'gaurang@gmail.com',4,2,2,2);
insert into donor values (5,'Aakash','Borivali',876543219,'aakash@gmail.com',5,2,2,2);
insert into donor values (6,'Shyam','Kandivali',987654321,'shyam@gmail.com',6,2,2,2);
insert into donor values (7,'Suchit','Andheri',984323422,'suchit@gmail.com',7,2,2,2);

insert into driver_has_hospital values(1,1);
insert into driver_has_hospital values(2,2);
insert into driver_has_hospital values(3,3);

select * from donor;
select * from donorhealthreport;
select * from nurse;
select * from nurse_has_labtechnician;
select * from receptionist;
select * from request;
select * from hospital;
select * from driver_has_hospital;
select * from bloodbank;
select * from blooddonationcamp;
select * from bloodinventory;
select * from bloodshipment;
select * from labtechnician;
select * from doctor;
select * from driver;


select donor.DonorName,donorhealthreport.BloodType,donorhealthreport.quantity
from donor join donorhealthreport
on donor.DonorHealthReport_ReportID = donorhealthreport.ReportID;

select hospital.HospitalName
from hospital join driver_has_hospital
on hospital.HospitalID = driver_has_hospital.Hospital_HospitalID;

select bloodbank.BloodBankName, request.Blood_Type_Requested,request.Quantity_Requested,request.Hospital_HospitalID
from bloodbank inner join request
on bloodbank.Request_RequestID = request.RequestID
where request.Blood_Type_Requested = 'B+';

select * from hospital_rquest_particular_bloodtype;

delimiter $$
create procedure revenue()
Begin
declare total_revenue integer;
set total_revenue = (Select Sum(amount)  from donorhealthreport);
select total_revenue as total_revenue;
End $$


update bloodinventory set bloodQuantity=(new.quantity+ abc)  
where bloodtype = new.bloodtype; $$

alter table mydb.bloodinventory 
drop BloodType;$$
alter table mydb.bloodinventory
 add BloodType enum('A+','B+','O+')
default null;

$$
select donorName,nurseName
from donor left join nurse
on donor.Nurse_NurseID = nurse.NurseID
where NurseID =2;
$$
create trigger blood_type_constraint before insert on donorhealthreport
for each row
begin
 if NEW.BloodType = "B+" or new.BloodType = "A+" or new.BloodType = "O+"
 then
 Select * from donorhealthreport;
 
end if;
end
$$

update bloodinventory set BloodType ='F+' where bloodinventory.BloodID = 3;