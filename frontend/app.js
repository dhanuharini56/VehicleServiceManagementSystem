

const API = "http://localhost:8080/api";

const $ = (id) => document.getElementById(id);

const today = new Date().toISOString().slice(0, 10);

// Set today's date
document.querySelectorAll('input[type="date"]').forEach(input => {
    input.value = today;
});

// Notification
function toast(message) {
    const t = $("toast");

    if (!t) {
        alert(message);
        return;
    }

    t.textContent = message;
    t.classList.add("show");

    setTimeout(() => {
        t.classList.remove("show");
    }, 2800);
}

// Backend API connection
async function api(path, opts = {}) {
    const response = await fetch(API + path, {
        ...opts,
        headers: {
            "Content-Type": "application/json",
            ...(opts.headers || {})
        }
    });

    const data = await response.json().catch(() => ({}));

    if (!response.ok) {
        throw new Error(
            data.message || "Request failed. Check backend and database."
        );
    }

    return data;
}

// Display table records
function render(id, rows, keys) {
    const table = $(id);

    if (!table) return;

    table.replaceChildren();

    if (!Array.isArray(rows) || rows.length === 0) {
        const tr = document.createElement("tr");
        const td = document.createElement("td");

        td.colSpan = keys.length;
        td.textContent = "No records yet";

        tr.appendChild(td);
        table.appendChild(tr);
        return;
    }

    rows.forEach(item => {
        const tr = document.createElement("tr");

        keys.forEach(key => {
            const td = document.createElement("td");
            td.textContent = item[key] ?? "";
            tr.appendChild(td);
        });

        table.appendChild(tr);
    });
}

// Load all dashboard data
async function loadAll() {
    const refreshButton = document.querySelector(
        'button[onclick="loadAll()"]'
    );

    try {
        if (refreshButton) {
            refreshButton.disabled = true;
            refreshButton.textContent = "Loading...";
        }

        const [
            dashboard,
            customers,
            vehicles,
            appointments,
            services,
            bills
        ] = await Promise.all([
            api("/dashboard"),
            api("/customers"),
            api("/vehicles"),
            api("/appointments"),
            api("/services"),
            api("/bills")
        ]);

        $("customerCount").textContent = dashboard.customers ?? 0;
        $("vehicleCount").textContent = dashboard.vehicles ?? 0;
        $("appointmentCount").textContent = dashboard.appointments ?? 0;
        $("serviceCount").textContent = dashboard.services ?? 0;

        render("customersTable", customers, [
            "customer_id",
            "customer_name",
            "phone",
            "email"
        ]);

        render("vehiclesTable", vehicles, [
            "vehicle_id",
            "vehicle_number",
            "brand",
            "model",
            "customer_name"
        ]);

        render("appointmentsTable", appointments, [
            "appointment_id",
            "customer_name",
            "vehicle_number",
            "appointment_date",
            "status"
        ]);

        render("servicesTable", services, [
            "service_id",
            "vehicle_number",
            "service_description",
            "service_date",
            "total_cost"
        ]);

        render("billsTable", bills, [
            "bill_id",
            "service_id",
            "vehicle_number",
            "bill_date",
            "amount",
            "payment_status"
        ]);

        console.log("Dashboard data loaded successfully");

    } catch (error) {
        console.error("Backend connection error:", error);
        toast(error.message);

    } finally {
        if (refreshButton) {
            refreshButton.disabled = false;
            refreshButton.textContent = "Refresh";
        }
    }
}

// Form submission
function bind(formId, path, message) {
    const form = $(formId);

    if (!form) {
        console.error("Form not found:", formId);
        return;
    }

    form.addEventListener("submit", async event => {
        event.preventDefault();

        const button = form.querySelector("button");

        if (button) button.disabled = true;

        try {
            const formData = Object.fromEntries(
                new FormData(form).entries()
            );

            await api(path, {
                method: "POST",
                body: JSON.stringify(formData)
            });

            form.reset();

            form.querySelectorAll('input[type="date"]')
                .forEach(input => {
                    input.value = today;
                });

            toast(message);

            await loadAll();

        } catch (error) {
            console.error("Form submission error:", error);
            toast(error.message);

        } finally {
            if (button) button.disabled = false;
        }
    });
}

// Connect forms
bind("customerForm", "/customers", "Customer saved");
bind("vehicleForm", "/vehicles", "Vehicle saved");
bind("appointmentForm", "/appointments", "Appointment booked");
bind("serviceForm", "/services", "Service record saved");
bind("billForm", "/bills", "Bill generated");

// Make loadAll available to HTML button
window.loadAll = loadAll;

// Initial loading
document.addEventListener("DOMContentLoaded", loadAll);
