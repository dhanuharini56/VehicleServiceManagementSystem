
package edu.student.vehicleservice;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = {
    "http://127.0.0.1:5500",
    "http://localhost:5500"
})
@RestController
@RequestMapping("/api")
public class ApiController {

    private final JdbcTemplate db;

    public ApiController(JdbcTemplate db) {
        this.db = db;
    }

    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {
        return Map.of(
            "customers", count("Customer"),
            "vehicles", count("Vehicle"),
            "appointments", count("Appointment"),
            "services", count("Service_Record")
        );
    }

    private int count(String table) {
        return db.queryForObject(
            "SELECT COUNT(*) FROM " + table,
            Integer.class
        );
    }

    // CUSTOMER DETAILS

    @GetMapping("/customers")
    public List<Map<String, Object>> customers() {
        return db.queryForList(
            "SELECT * FROM Customer ORDER BY customer_id DESC"
        );
    }

    @PostMapping("/customers")
    public Map<String, Object> addCustomer(
        @RequestBody Map<String, Object> b
    ) {
        db.update(
            "INSERT INTO Customer(customer_name,phone,email,address) VALUES(?,?,?,?)",
            req(b, "customerName"),
            req(b, "phone"),
            b.get("email"),
            b.get("address")
        );

        return Map.of("message", "Customer saved");
    }

    // VEHICLE DETAILS

    @GetMapping("/vehicles")
    public List<Map<String, Object>> vehicles() {
        return db.queryForList(
            "SELECT v.*, c.customer_name FROM Vehicle v " +
            "JOIN Customer c ON c.customer_id = v.customer_id " +
            "ORDER BY v.vehicle_id DESC"
        );
    }

    @PostMapping("/vehicles")
    public Map<String, Object> addVehicle(
        @RequestBody Map<String, Object> b
    ) {
        db.update(
            "INSERT INTO Vehicle(customer_id,vehicle_number,brand,model,vehicle_type,manufacture_year) VALUES(?,?,?,?,?,?)",
            num(b, "customerId"),
            req(b, "vehicleNumber"),
            b.get("brand"),
            req(b, "model"),
            b.get("vehicleType"),
            nullableNum(b.get("manufactureYear"))
        );

        return Map.of("message", "Vehicle saved");
    }

    // APPOINTMENTS

    @GetMapping("/appointments")
    public List<Map<String, Object>> appointments() {
        return db.queryForList(
            "SELECT a.*, c.customer_name, v.vehicle_number " +
            "FROM Appointment a " +
            "JOIN Customer c ON c.customer_id = a.customer_id " +
            "JOIN Vehicle v ON v.vehicle_id = a.vehicle_id " +
            "ORDER BY a.appointment_id DESC"
        );
    }

    @PostMapping("/appointments")
    public Map<String, Object> addAppointment(
        @RequestBody Map<String, Object> b
    ) {
        db.update(
            "INSERT INTO Appointment(customer_id,vehicle_id,appointment_date,issue_description,status) VALUES(?,?,?,?, 'BOOKED')",
            num(b, "customerId"),
            num(b, "vehicleId"),
            Date.valueOf(req(b, "appointmentDate")),
            b.get("issueDescription")
        );

        return Map.of("message", "Appointment booked");
    }

    // SERVICE RECORDS

    @GetMapping("/services")
    public List<Map<String, Object>> services() {
        return db.queryForList(
            "SELECT s.*, v.vehicle_number FROM Service_Record s " +
            "JOIN Vehicle v ON v.vehicle_id = s.vehicle_id " +
            "ORDER BY s.service_id DESC"
        );
    }

    @PostMapping("/services")
    public Map<String, Object> addService(
        @RequestBody Map<String, Object> b
    ) {
        BigDecimal labor = money(b, "laborCost");
        BigDecimal parts = money(b, "partsCost");

        db.update(
            "INSERT INTO Service_Record(vehicle_id,service_date,service_description,labor_cost,parts_cost,total_cost,next_service_date) VALUES(?,?,?,?,?,?,?)",
            num(b, "vehicleId"),
            Date.valueOf(req(b, "serviceDate")),
            req(b, "serviceDescription"),
            labor,
            parts,
            labor.add(parts),
            optDate(b.get("nextServiceDate"))
        );

        return Map.of(
            "message", "Service record saved",
            "totalCost", labor.add(parts)
        );
    }

    // BILLING

    @GetMapping("/bills")
    public List<Map<String, Object>> bills() {
        return db.queryForList(
            "SELECT b.*, s.service_description, v.vehicle_number " +
            "FROM Bill b " +
            "JOIN Service_Record s ON s.service_id = b.service_id " +
            "JOIN Vehicle v ON v.vehicle_id = s.vehicle_id " +
            "ORDER BY b.bill_id DESC"
        );
    }

    @PostMapping("/bills")
    public Map<String, Object> addBill(
        @RequestBody Map<String, Object> b
    ) {
        db.update(
            "INSERT INTO Bill(service_id,bill_date,amount,payment_status,payment_method) VALUES(?,?,?,?,?)",
            num(b, "serviceId"),
            Date.valueOf(req(b, "billDate")),
            money(b, "amount"),
            b.getOrDefault("paymentStatus", "PENDING"),
            b.get("paymentMethod")
        );

        return Map.of("message", "Bill generated");
    }

    // COMMON METHODS

    private String req(Map<String, Object> b, String k) {
        Object v = b.get(k);

        if (v == null || v.toString().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                k + " is required"
            );
        }

        return v.toString().trim();
    }

    private int num(Map<String, Object> b, String k) {
        try {
            return Integer.parseInt(req(b, k));
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                k + " must be a number"
            );
        }
    }

    private Integer nullableNum(Object v) {
        if (v == null || v.toString().isBlank()) {
            return null;
        }

        try {
            return Integer.valueOf(v.toString());
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Manufacture year must be a number"
            );
        }
    }

    private BigDecimal money(Map<String, Object> b, String k) {
        try {
            return new BigDecimal(req(b, k));
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                k + " must be a valid amount"
            );
        }
    }

    private Date optDate(Object v) {
        return v == null || v.toString().isBlank()
            ? null
            : Date.valueOf(v.toString());
    }
}
