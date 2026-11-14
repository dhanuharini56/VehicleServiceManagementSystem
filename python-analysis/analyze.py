

from pathlib import Path
import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.ticker import FuncFormatter
import mysql.connector
from db_config import DB_CONFIG

OUT = Path(__file__).parent / "output"
OUT.mkdir(exist_ok=True)

plt.rcParams.update({
    "figure.dpi": 120,
    "savefig.dpi": 300,
    "font.family": "DejaVu Sans",
    "font.size": 11,
    "axes.titlesize": 18,
    "axes.titleweight": "bold",
    "axes.labelsize": 12,
    "axes.spines.top": False,
    "axes.spines.right": False,
    "axes.edgecolor": "#D9DEE7",
    "axes.facecolor": "white",
    "figure.facecolor": "white"
})


def main():
    conn = mysql.connector.connect(**DB_CONFIG)

    try:
        customers = pd.read_sql(
            "SELECT * FROM Customer", conn
        )

        services = pd.read_sql(
            "SELECT sr.service_id, sr.service_date, "
            "sr.service_description, sr.labor_cost, "
            "sr.parts_cost, sr.total_cost, "
            "v.vehicle_number "
            "FROM Service_Record sr "
            "JOIN Vehicle v ON v.vehicle_id=sr.vehicle_id",
            conn
        )

        print("\nVEHICLE SERVICE MANAGEMENT ANALYSIS")
        print("-----------------------------------")
        print("Total customers:", len(customers))
        print("Total service records:", len(services))

        if services.empty:
            print("No service records available.")
            return

        services["service_date"] = pd.to_datetime(
            services["service_date"]
        )

        total_cost = services["total_cost"].sum()

        print("Total maintenance cost: Rs.",
              round(total_cost, 2))

        # CHART 1: MAINTENANCE COST BY VEHICLE

        vehicle_cost = (
            services.groupby("vehicle_number")["total_cost"]
            .sum()
            .sort_values(ascending=True)
        )

        fig, ax = plt.subplots(figsize=(10, 6))

        bars = ax.barh(
            vehicle_cost.index.astype(str),
            vehicle_cost.values,
            color="#2878B5",
            height=0.48,
            edgecolor="white"
        )

        ax.set_title(
            "Maintenance Cost by Vehicle",
            pad=22
        )
        ax.set_xlabel("Maintenance Cost (Rs.)", labelpad=12)
        ax.set_ylabel("Vehicle Number", labelpad=12)

        ax.xaxis.set_major_formatter(
            FuncFormatter(lambda x, _: f"Rs. {x:,.0f}")
        )

        ax.grid(
            axis="x",
            linestyle="--",
            alpha=0.25
        )
        ax.set_axisbelow(True)

        ax.bar_label(
            bars,
            labels=[
                f"Rs. {v:,.2f}"
                for v in vehicle_cost.values
            ],
            padding=8,
            fontweight="bold",
            fontsize=10
        )

        ax.set_xlim(
            0,
            max(vehicle_cost.max() * 1.30, 1)
        )

        fig.tight_layout()

        fig.savefig(
            OUT / "maintenance_cost_by_vehicle.png",
            bbox_inches="tight",
            facecolor="white"
        )

        plt.close(fig)

        # CHART 2: SERVICE RECORDS BY MONTH

        monthly_services = (
            services.groupby(
                services["service_date"].dt.to_period("M")
            )
            .size()
        )

        month_labels = (
            monthly_services.index
            .to_timestamp()
            .strftime("%b %Y")
        )

        fig, ax = plt.subplots(figsize=(10, 6))

        bars = ax.bar(
            month_labels,
            monthly_services.values,
            color="#F39C35",
            width=0.48,
            edgecolor="white"
        )

        ax.set_title(
            "Service Records by Month",
            pad=22
        )
        ax.set_xlabel("Month", labelpad=12)
        ax.set_ylabel("Number of Services", labelpad=12)

        ax.grid(
            axis="y",
            linestyle="--",
            alpha=0.25
        )
        ax.set_axisbelow(True)

        ax.bar_label(
            bars,
            padding=7,
            fontweight="bold",
            fontsize=11
        )

        ax.set_ylim(
            0,
            max(monthly_services.max() * 1.35, 1)
        )

        fig.tight_layout()

        fig.savefig(
            OUT / "services_by_month.png",
            bbox_inches="tight",
            facecolor="white"
        )

        plt.close(fig)

        print("\nProfessional charts generated successfully!")
        print("Charts saved in:", OUT)

    finally:
        conn.close()


if __name__ == "__main__":
    main()