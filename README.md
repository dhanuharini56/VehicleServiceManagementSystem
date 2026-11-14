# Vehicle Service Management and Maintenance Analysis System

## 1. Project Overview

The Vehicle Service Management and Maintenance Analysis System is a web-based application developed to manage vehicle service center activities.

The application provides features for customer registration, vehicle management, appointment booking, service record maintenance, bill generation, dashboard monitoring, and maintenance cost analysis.

The project integrates Java, Spring Boot, MySQL, HTML, CSS, JavaScript, and Python.

## 2. Technologies Used

| Technology | Purpose |
|---|---|
| Java | Backend programming |
| Spring Boot | Backend framework |
| Maven | Project build and dependency management |
| MySQL | Database management |
| HTML | Frontend structure |
| CSS | Frontend styling |
| JavaScript | Frontend functionality and API communication |
| Python | Maintenance data analysis |
| VS Code | Development environment |
| Git and GitHub | Version control and project hosting |

## 3. Main Modules

1. Customer Management
2. Vehicle Management
3. Appointment Booking
4. Service Record Management
5. Bill Management
6. Dashboard
7. Maintenance Cost Analysis
8. Reports and Charts

## 4. Project Folder Structure

```text
VehicleServiceManagementSystem_FullProject/
│
├── backend/
│   ├── src/
│   └── pom.xml
│
├── database/
│   ├── schema.sql
│   └── sample_data.sql
│
├── documentation/
│   ├── SRS.md
│   ├── project-overview.md
│   ├── database-design.md
│   ├── architecture-and-flow.md
│   ├── test-cases.md
│   ├── report-template.md
│   ├── use-case-diagram.puml
│   ├── class-diagram.puml
│   ├── sequence-diagram.puml
│   ├── activity-diagram.puml
│   └── er-diagram.puml
│
├── frontend/
│   ├── index.html
│   ├── style.css
│   ├── app.js
│   └── charts/
│
├── python-analysis/
│   ├── analyze.py
│   └── requirements.txt
│
├── .gitignore
└── README.md
```

## 5. Software Requirements

- Windows 10 / Windows 11
- JDK 17 or above
- Apache Maven
- MySQL 8
- Python 3.10 or above
- Visual Studio Code
- Google Chrome or another modern browser

## 6. Database Setup

1. Open MySQL Workbench.
2. Open the `database/schema.sql` file.
3. Execute the SQL script.
4. Optionally execute `database/sample_data.sql` to insert sample records.
5. Verify that the `VehicleServiceDB` database has been created.

## 7. Backend Setup

1. Open the project folder in VS Code.
2. Open a terminal.
3. Navigate to the backend folder:

```powershell
cd backend
```

4. Configure the local MySQL connection in:

```text
backend/src/main/resources/application.properties
```

5. Set your local database username and password. Do not upload actual credentials to GitHub.
6. Start the Spring Boot backend:

```powershell
mvn spring-boot:run
```

The backend runs at:

`http://localhost:8080`

## 8. Frontend Setup

1. Open a new terminal in the project root folder.
2. Start the frontend server:

```powershell
cd frontend
python -m http.server 5500
```

3. Open the following URL in your browser:

`http://localhost:5500`

Keep the backend and frontend servers running while using the application.

## 9. Python Analysis Setup

1. Open a new terminal in the project root folder.
2. Install the required Python packages:

```powershell
python -m pip install -r python-analysis/requirements.txt
```

3. Configure the local database connection in `python-analysis/db_config.py`.
4. Run the analysis script:

```powershell
python python-analysis/analyze.py
```

The analysis generates maintenance reports and charts based on available database records.

## 10. Reports and Analysis

The Python analysis module provides:

- Maintenance cost by vehicle.
- Number of services by month.

Generated charts are stored in the Python output folder and displayed in the frontend reports section.

## 11. Documentation

The `documentation` folder contains:

- Software Requirements Specification (SRS)
- Project Overview
- Database Design
- System Architecture and Flow
- Test Cases
- Use Case Diagram
- Class Diagram
- Sequence Diagram
- Activity Diagram
- Entity Relationship (ER) Diagram

## 12. GitHub Repository

The source code and project documentation are maintained in the individual GitHub repository.

Repository: https://github.com/dhanuharini56/VehicleServiceManagementSystem

## 13. Security Notes

- Do not upload database passwords.
- Keep local configuration files out of the public repository.
- Use the `.gitignore` file to exclude sensitive files and unnecessary generated files.

## 14. Conclusion

The Vehicle Service Management and Maintenance Analysis System provides an organized solution for vehicle service center operations.

It combines frontend technologies, Java Spring Boot, MySQL, and Python to manage service records and analyze vehicle maintenance costs.