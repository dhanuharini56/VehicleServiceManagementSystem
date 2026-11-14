# SOFTWARE REQUIREMENTS SPECIFICATION (SRS)

## VEHICLE SERVICE MANAGEMENT AND MAINTENANCE ANALYSIS SYSTEM

**Project Title:** Vehicle Service Management and Maintenance Analysis System  
**Department:** Information Technology  
**Academic Year:** 2026–2027  
**Project Type:** Individual Project  

---

# 1. INTRODUCTION

## 1.1 Purpose

The purpose of this Software Requirements Specification (SRS) document is to describe the functional and non-functional requirements of the Vehicle Service Management and Maintenance Analysis System.

This system is developed to manage vehicle service center activities such as customer registration, vehicle registration, appointment booking, service record maintenance, bill generation, and maintenance cost analysis.

This document explains the system features, users, operating environment, database requirements, and expected system behavior.

## 1.2 Scope

The Vehicle Service Management and Maintenance Analysis System is a web-based application designed to simplify and organize vehicle service center operations.

The system allows staff or administrators to:

- Register and manage customer details.
- Register vehicles linked to customers.
- Book service appointments.
- Maintain vehicle service records.
- Calculate labour and spare parts costs.
- Generate bills for completed services.
- View dashboard summaries.
- Analyze vehicle maintenance costs using Python.
- View maintenance analysis charts and reports.

The system uses Java Spring Boot for backend development, MySQL for database management, HTML, CSS, and JavaScript for the frontend, and Python for data analysis.

## 1.3 Objectives

The main objectives are:

1. To maintain customer and vehicle information digitally.
2. To simplify vehicle service appointment management.
3. To maintain accurate service history.
4. To calculate service costs automatically.
5. To generate bills based on service records.
6. To reduce manual record-keeping.
7. To analyze maintenance costs using Python.
8. To provide useful reports for service center management.

## 1.4 Definitions and Abbreviations

| Term | Description |
|---|---|
| SRS | Software Requirements Specification |
| UI | User Interface |
| API | Application Programming Interface |
| DBMS | Database Management System |
| SQL | Structured Query Language |
| CRUD | Create, Read, Update, Delete |
| JDK | Java Development Kit |
| UML | Unified Modeling Language |

---

# 2. OVERALL DESCRIPTION

## 2.1 Product Perspective

The Vehicle Service Management and Maintenance Analysis System is a web-based application that connects a frontend interface with a Java Spring Boot backend and a MySQL database.

Python is used to analyze service data and generate maintenance reports.

The system follows a layered architecture consisting of:

- Presentation Layer – HTML, CSS, and JavaScript.
- Application Layer – Java Spring Boot.
- Database Layer – MySQL.
- Analysis Layer – Python.

## 2.2 Product Functions

The major functions of the system are:

1. Customer Management
2. Vehicle Management
3. Appointment Management
4. Service Record Management
5. Bill Management
6. Dashboard Management
7. Maintenance Cost Analysis
8. Report Visualization

## 2.3 User Classes

### Service Center Administrator

The administrator can manage customer information, vehicle details, appointments, service records, bills, and maintenance reports.

### Service Center Staff

Staff members can enter customer details, register vehicles, book appointments, update service information, and maintain billing records.

**Note:** The current project does not include a separate login or authentication module.

## 2.4 Operating Environment

The application requires the following software and environment:

| Component | Requirement |
|---|---|
| Operating System | Windows 10 / Windows 11 |
| Programming Language | Java |
| JDK | JDK 17 or above |
| Backend Framework | Spring Boot |
| Build Tool | Apache Maven |
| Database | MySQL 8 |
| Frontend | HTML, CSS, JavaScript |
| Data Analysis | Python 3.10 or above |
| Code Editor | Visual Studio Code |
| Browser | Google Chrome or modern web browser |

## 2.5 Design and Implementation Constraints

- The backend must be developed using Java Spring Boot.
- MySQL must be used for persistent data storage.
- The frontend must communicate with the backend through API requests.
- Python must be used for maintenance data analysis.
- Database credentials must be stored securely and must not be exposed in the public repository.
- The application requires the backend and frontend services to be running for local access.

## 2.6 Assumptions and Dependencies

- The user has access to a computer with the required software installed.
- MySQL must be running before the application accesses database records.
- The backend must be running before frontend API operations can work.
- Python dependencies must be installed for maintenance analysis.
- Customer and vehicle information must be entered before creating related service records.

---

# 3. SYSTEM REQUIREMENTS

## 3.1 Functional Requirements

### FR-01: Customer Management

- The system shall allow staff to register new customers.
- The system shall store customer name, phone number, email, and address.
- The system shall display registered customer details.
- Each customer shall have a unique customer ID.

### FR-02: Vehicle Management

- The system shall allow staff to register vehicles.
- Each vehicle shall be linked to a registered customer.
- The system shall store vehicle number, brand, model, vehicle type, and manufacture year.
- Each vehicle shall have a unique vehicle ID.
- Vehicle registration numbers shall be unique.

### FR-03: Appointment Management

- The system shall allow staff to book service appointments.
- Each appointment shall be associated with a customer and vehicle.
- The system shall store appointment date, issue description, and status.
- The system shall display appointment information.

### FR-04: Service Record Management

- The system shall allow staff to create service records.
- Each service record shall be associated with a vehicle.
- The system shall store service date and service description.
- The system shall record labour cost and spare parts cost.
- The system shall calculate the total service cost.
- The system shall store the next service date when provided.

### FR-05: Bill Management

- The system shall generate a bill for a service record.
- The system shall store bill date and bill amount.
- The system shall maintain payment status.
- The system shall support storing the payment method.

### FR-06: Dashboard Management

- The system shall display the total number of customers.
- The system shall display the total number of vehicles.
- The system shall display the total number of appointments.
- The system shall display the total number of service records.

### FR-07: Maintenance Cost Analysis

- The system shall use Python to analyze service data.
- The system shall analyze maintenance costs by vehicle.
- The system shall analyze the number of services by month.
- The system shall generate graphical reports.
- The generated charts shall be displayed in the reports section.

## 3.2 Non-Functional Requirements

### 3.2.1 Usability

- The application shall provide a simple and user-friendly interface.
- Forms shall have clear labels.
- Information shall be displayed in an organized manner.
- Navigation between modules shall be easy.

### 3.2.2 Performance

- The application shall process normal user requests within a reasonable time.
- Database operations shall avoid unnecessary delays.
- Reports shall be generated based on available service data.

### 3.2.3 Reliability

- The system shall store records in the MySQL database.
- Stored records shall remain available after application restarts.
- The application shall handle invalid inputs appropriately.

### 3.2.4 Security

- Database credentials shall not be exposed in the public GitHub repository.
- Input validation shall be applied to data entry forms.
- Database access shall be handled through the backend.

### 3.2.5 Maintainability

- The application shall use modular code.
- Frontend, backend, database, and Python analysis files shall be maintained separately.
- The source code shall be organized into clearly named folders.

### 3.2.6 Portability

- The application shall run on supported Windows environments.
- The frontend shall be accessible through a modern web browser.

---

# 4. SYSTEM ARCHITECTURE

The system consists of four major components.

## 4.1 Frontend

The frontend is developed using:

- HTML
- CSS
- JavaScript

It provides forms, tables, dashboard information, and report visualization.

## 4.2 Backend

The backend is developed using Java Spring Boot.

It handles:

- API requests.
- Customer and vehicle operations.
- Appointment management.
- Service record operations.
- Billing operations.
- Database communication.

## 4.3 Database

MySQL is used to store customer, vehicle, appointment, service record, and billing information.

## 4.4 Python Analysis

Python is used to process service data and generate maintenance analysis charts.

The analysis includes:

- Maintenance cost by vehicle.
- Services by month.

---

# 5. DATABASE REQUIREMENTS

The system uses a MySQL database named `VehicleServiceDB`.

The database contains the following tables.

## 5.1 Customer Table

Stores customer information.

| Field | Description |
|---|---|
| customer_id | Primary Key |
| customer_name | Customer name |
| phone | Phone number |
| email | Email address |
| address | Customer address |
| created_at | Record creation timestamp |

## 5.2 Vehicle Table

Stores vehicle information linked to customers.

| Field | Description |
|---|---|
| vehicle_id | Primary Key |
| customer_id | Foreign Key |
| vehicle_number | Unique vehicle registration number |
| brand | Vehicle brand |
| model | Vehicle model |
| vehicle_type | Type of vehicle |
| manufacture_year | Year of manufacture |

## 5.3 Appointment Table

Stores vehicle service appointment details.

| Field | Description |
|---|---|
| appointment_id | Primary Key |
| customer_id | Foreign Key |
| vehicle_id | Foreign Key |
| appointment_date | Appointment date |
| issue_description | Reported vehicle issue |
| status | Appointment status |

## 5.4 Service_Record Table

Stores vehicle service details and costs.

| Field | Description |
|---|---|
| service_id | Primary Key |
| appointment_id | Foreign Key (Optional) |
| vehicle_id | Foreign Key |
| service_date | Service date |
| service_description | Service description |
| labor_cost | Labour cost |
| parts_cost | Spare parts cost |
| total_cost | Total service cost |
| next_service_date | Next service date |

## 5.5 Bill Table

Stores billing information.

| Field | Description |
|---|---|
| bill_id | Primary Key |
| service_id | Foreign Key |
| bill_date | Bill date |
| amount | Bill amount |
| payment_status | Payment status |
| payment_method | Payment method |

## 5.6 Database Relationships

- One customer can have multiple vehicles.
- One customer can have multiple appointments.
- One vehicle can have multiple appointments.
- One vehicle can have multiple service records.
- An appointment can be associated with multiple service records; a service record may also exist without an appointment.
- One service record can have multiple bills.

---

# 6. EXTERNAL INTERFACE REQUIREMENTS

## 6.1 User Interface

The application shall provide:

- Dashboard page.
- Customer details form.
- Vehicle details form.
- Appointment booking form.
- Service record form.
- Billing section.
- Maintenance reports section.

## 6.2 Software Interface

The frontend communicates with the Spring Boot backend through HTTP API requests.

The backend communicates with the MySQL database to store and retrieve information.

Python scripts access the required service data for analysis and chart generation.

## 6.3 Hardware Interface

The application requires a computer with sufficient memory and storage to run the development tools, database, backend, frontend, and Python environment.

---

# 7. SYSTEM WORKFLOW

The general workflow of the application is:

1. Open the Vehicle Service Management System.
2. View the dashboard.
3. Register customer details.
4. Register the customer's vehicle.
5. Book a service appointment.
6. Create a service record.
7. Enter labour and spare parts costs.
8. Calculate the total service cost.
9. Generate a bill.
10. View maintenance reports.
11. Analyze service data using Python.

---

# 8. TESTING REQUIREMENTS

The following test cases are used to verify the major system functions.

| Test Case ID | Test Scenario | Expected Result |
|---|---|---|
| TC-01 | Register a new customer | Customer details should be saved |
| TC-02 | Register a vehicle | Vehicle should be linked to the customer |
| TC-03 | Book an appointment | Appointment should be saved |
| TC-04 | Create a service record | Service details should be saved |
| TC-05 | Calculate service cost | Labour and parts costs should be added |
| TC-06 | Generate a bill | Bill details should be saved |
| TC-07 | View dashboard | Dashboard totals should be displayed |
| TC-08 | Run Python analysis | Maintenance charts should be generated |
| TC-09 | View reports | Generated charts should be displayed |

---

# 9. FUTURE ENHANCEMENTS

The following features may be added in future versions:

- User login and role-based access.
- Customer login portal.
- Online appointment booking.
- Email or SMS service reminders.
- Online payment integration.
- Downloadable PDF invoices.
- Advanced maintenance prediction.
- Additional analytical reports.

---

# 10. CONCLUSION

The Vehicle Service Management and Maintenance Analysis System provides a structured solution for managing vehicle service center operations.

It combines Java Spring Boot, MySQL, HTML, CSS, JavaScript, and Python to manage customer details, vehicles, appointments, service records, billing, and maintenance analysis.

The system reduces manual record-keeping, improves data organization, and provides useful maintenance reports.

This SRS document defines the requirements and overall design of the proposed system and serves as a reference for its development, testing, and evaluation.