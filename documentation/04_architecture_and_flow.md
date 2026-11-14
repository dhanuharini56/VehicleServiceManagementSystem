# Architecture and Data Flow

## 1. System Architecture

The Vehicle Service Management and Maintenance Analysis System follows a three-tier architecture with a separate Python-based analysis component.

### Architecture Diagram

```text
                 User / Staff
                      |
                      v
          HTML, CSS and JavaScript
                 Frontend
                      |
                      v
           Java Spring Boot REST API
                   Backend
                      |
                      v
                MySQL Database
                      |
                      v
             Python Analysis Module
                (Pandas)
                      |
                      v
               Analysis Charts
                      |
                      v
             Frontend Reports Section
```

## 2. System Modules

1. **Customer Management:** Add and view customer details.
2. **Vehicle Management:** Register and manage vehicles linked to customers.
3. **Appointment Management:** Book and manage service appointments.
4. **Service Records:** Store service details, labour costs and parts costs.
5. **Billing:** Generate and manage bills for service records.
6. **Reports and Analysis:** Display maintenance cost and monthly service analysis charts.

## 3. Data Flow

The system follows these steps:

1. Staff opens the Vehicle Service Management System through the frontend.
2. Customer details are entered and sent to the Java Spring Boot backend.
3. The backend stores customer information in the MySQL database.
4. Vehicle details are registered and linked to the respective customer.
5. Staff books service appointments for registered vehicles.
6. Completed service details and maintenance costs are stored in the database.
7. Bills are generated using service record details.
8. The Python analysis module uses Pandas to analyze maintenance data from the database.
9. Analysis charts are generated and displayed in the Reports section of the frontend.

## 4. Technologies Used

- Frontend: HTML, CSS, JavaScript
- Backend: Java Spring Boot
- Database: MySQL
- Data Analysis: Python and Pandas
- Development Tool: Visual Studio Code

## 5. Conclusion

The system integrates frontend technologies, Java backend services, MySQL database management and Python-based data analysis to manage vehicle service operations and generate maintenance reports.