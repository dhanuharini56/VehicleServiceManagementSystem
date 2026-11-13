USE VehicleServiceDB;
INSERT INTO Customer(customer_name,phone,email,address) VALUES
('Arun Kumar','9876543210','arun@example.com','Erode'),
('Bala','9876501234','bala@example.com','Perundurai');
INSERT INTO Vehicle(customer_id,vehicle_number,brand,model,vehicle_type,manufacture_year) VALUES
(1,'TN ERO 1234','Honda','Activa','Two Wheeler',2022),
(2,'TN ERO 5678','Hyundai','i20','Four Wheeler',2021);
INSERT INTO Appointment(customer_id,vehicle_id,appointment_date,issue_description,status) VALUES
(1,1,CURRENT_DATE,'General service','BOOKED'),
(2,2,CURRENT_DATE,'Brake inspection','BOOKED');
INSERT INTO Service_Record(appointment_id,vehicle_id,service_date,service_description,labor_cost,parts_cost,total_cost,next_service_date)
VALUES(1,1,CURRENT_DATE,'Oil change and general check',500,900,1400,DATE_ADD(CURRENT_DATE,INTERVAL 6 MONTH));
INSERT INTO Bill(service_id,bill_date,amount,payment_status,payment_method)
VALUES(1,CURRENT_DATE,1400,'PAID','CASH');
