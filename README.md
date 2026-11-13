# Vehicle Service Management and Maintenance Analysis System

Student project package: HTML/CSS/JavaScript frontend, Java Spring Boot backend, MySQL database, Python analysis, and Software Engineering documentation.

## Requirements
JDK 17+, Maven 3.8+, MySQL 8, Python 3.10+.

## Setup
1. In MySQL Workbench, execute `database/schema.sql`. Optionally execute `database/sample_data.sql`.
2. Edit `backend/src/main/resources/application.properties` and replace `YOUR_MYSQL_PASSWORD` with your local MySQL root password. Never publish your password.
3. Open a terminal in `backend` and run `mvn spring-boot:run`.
4. Open `http://localhost:8080` in a browser. The frontend uses the Java API and stores records in MySQL.
5. For Python analysis, install `python -m pip install -r python-analysis/requirements.txt`, edit `python-analysis/db_config.py`, then run `python python-analysis/analyze.py`.

## GitHub
From the project root: `git init`, `git add .`, `git commit -m "Initial project"`, then add your own GitHub remote and push. Do not upload passwords. Add your own screenshots and actual test results before submission.

This is a complete learning-project starter, not a claim that your local installation has already been tested. Follow the setup steps and resolve any environment-specific errors.
