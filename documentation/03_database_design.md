# DATABASE DESIGN

## Vehicle Service Management and Maintenance Analysis System

## 1. Introduction

The database is designed to store and manage customer details, vehicle information, service appointments, service records, and billing information.

The system uses MySQL as its database management system.

**Database Name:** `VehicleServiceDB`

## 2. Database Tables

The database consists of five main tables.

### 2.1 Customer Table

Stores customer information.

| Column | Data Type | Constraint |
|---|---|---|
| customer_id | INT | Primary Key, Auto Increment |
| customer_name | VARCHAR(100) | NOT NULL |
| phone | VARCHAR(15) | NOT NULL |
| email | VARCHAR(120) | Optional |
| address | VARCHAR(255) | Optional |
| created_at | TIMESTAMP | Default Current Timestamp |

### 2.2 Vehicle Table

Stores vehicle information linked to customers.

| Column | Data Type | Constraint |
|---|---|---|
| vehicle_id | INT | Primary Key, Auto Increment |
| customer_id | INT | Foreign Key |
| vehicle_number | VARCHAR(20) | UNIQUE |
| brand | VARCHAR(60) | Optional |
| model | VARCHAR(60) | NOT NULL |
| vehicle_type | VARCHAR(40) | Optional |
| manufacture_year | INT | Optional |

### 2.3 Appointment Table

Stores vehicle service appointment details.

| Column | Data Type | Constraint |
|---|---|---|
| appointment_id | INT | Primary Key, Auto Increment |
| customer_id | INT | Foreign Key |
| vehicle_id | INT | Foreign Key |
| appointment_date | DATE | NOT NULL |
| issue_description | VARCHAR(500) | Optional |
| status | VARCHAR(30) | Default BOOKED |

### 2.4 Service_Record Table

Stores service history and maintenance costs.

| Column | Data Type | Constraint |
|---|---|---|
| service_id | INT | Primary Key, Auto Increment |
| appointment_id | INT | Optional Foreign Key |
| vehicle_id | INT | Foreign Key |
| service_date | DATE | NOT NULL |
| service_description | VARCHAR(500) | NOT NULL |
| labor_cost | DECIMAL(10,2) | Default 0 |
| parts_cost | DECIMAL(10,2) | Default 0 |
| total_cost | DECIMAL(10,2) | Default 0 |
| next_service_date | DATE | Optional |

### 2.5 Bill Table

Stores billing and payment information.

| Column | Data Type | Constraint |
|---|---|---|
| bill_id | INT | Primary Key, Auto Increment |
| service_id | INT | Foreign Key |
| bill_date | DATE | NOT NULL |
| amount | DECIMAL(10,2) | NOT NULL |
| payment_status | VARCHAR(30) | Default PENDING |
| payment_method | VARCHAR(30) | Optional |

## 3. Primary Keys

Each table has a primary key to uniquely identify its records.

- Customer – customer_id
- Vehicle – vehicle_id
- Appointment – appointment_id
- Service_Record – service_id
- Bill – bill_id

## 4. Foreign Key Relationships

- Vehicle.customer_id references Customer.customer_id.
- Appointment.customer_id references Customer.customer_id.
- Appointment.vehicle_id references Vehicle.vehicle_id.
- Service_Record.appointment_id references Appointment.appointment_id.
- Service_Record.vehicle_id references Vehicle.vehicle_id.
- Bill.service_id references Service_Record.service_id.

## 5. Database Relationships

1. One customer can have multiple vehicles.
2. One customer can have multiple appointments.
3. One vehicle can have multiple appointments.
4. One vehicle can have multiple service records.
5. An appointment can be associated with multiple service records.
6. A service record can have multiple bills.

## 6. Database Constraints

- Primary keys uniquely identify each record.
- Foreign keys maintain relationships between tables.
- Vehicle registration numbers must be unique.
- Required fields cannot contain NULL values.
- Auto Increment generates unique IDs automatically.
- Default values are used for appointment status, payment status, and service costs.

## 7. Conclusion

The MySQL database provides structured storage for all major activities of the Vehicle Service Management and Maintenance Analysis System.

The database relationships help maintain data consistency and support efficient retrieval of customer, vehicle, appointment, service, and billing information.

**SQL File:** `database/schema.sql`