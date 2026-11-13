# Database Design
| Table | Primary Key | Foreign Keys |
|---|---|---|
| Customer | customer_id | — |
| Vehicle | vehicle_id | customer_id → Customer |
| Appointment | appointment_id | customer_id → Customer; vehicle_id → Vehicle |
| Service_Record | service_id | appointment_id → Appointment (optional); vehicle_id → Vehicle |
| Bill | bill_id | service_id → Service_Record |
One customer can own many vehicles. A vehicle can have many appointments and service records. A service record can have a bill. See `database/schema.sql`.
