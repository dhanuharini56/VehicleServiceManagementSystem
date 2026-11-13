CREATE DATABASE IF NOT EXISTS VehicleServiceDB;
USE VehicleServiceDB;

CREATE TABLE IF NOT EXISTS Customer (
 customer_id INT AUTO_INCREMENT PRIMARY KEY,
 customer_name VARCHAR(100) NOT NULL,
 phone VARCHAR(15) NOT NULL,
 email VARCHAR(120),
 address VARCHAR(255),
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Vehicle (
 vehicle_id INT AUTO_INCREMENT PRIMARY KEY,
 customer_id INT NOT NULL,
 vehicle_number VARCHAR(20) NOT NULL UNIQUE,
 brand VARCHAR(60),
 model VARCHAR(60) NOT NULL,
 vehicle_type VARCHAR(40),
 manufacture_year INT,
 FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

CREATE TABLE IF NOT EXISTS Appointment (
 appointment_id INT AUTO_INCREMENT PRIMARY KEY,
 customer_id INT NOT NULL,
 vehicle_id INT NOT NULL,
 appointment_date DATE NOT NULL,
 issue_description VARCHAR(500),
 status VARCHAR(30) NOT NULL DEFAULT 'BOOKED',
 FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
 FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id)
);

CREATE TABLE IF NOT EXISTS Service_Record (
 service_id INT AUTO_INCREMENT PRIMARY KEY,
 appointment_id INT NULL,
 vehicle_id INT NOT NULL,
 service_date DATE NOT NULL,
 service_description VARCHAR(500) NOT NULL,
 labor_cost DECIMAL(10,2) NOT NULL DEFAULT 0,
 parts_cost DECIMAL(10,2) NOT NULL DEFAULT 0,
 total_cost DECIMAL(10,2) NOT NULL DEFAULT 0,
 next_service_date DATE,
 FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id),
 FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id)
);

CREATE TABLE IF NOT EXISTS Bill (
 bill_id INT AUTO_INCREMENT PRIMARY KEY,
 service_id INT NOT NULL,
 bill_date DATE NOT NULL,
 amount DECIMAL(10,2) NOT NULL,
 payment_status VARCHAR(30) NOT NULL DEFAULT 'PENDING',
 payment_method VARCHAR(30),
 FOREIGN KEY (service_id) REFERENCES Service_Record(service_id)
);
