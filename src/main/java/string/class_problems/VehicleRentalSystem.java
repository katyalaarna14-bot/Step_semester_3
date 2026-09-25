package string.class_problems;

import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String vehicleNumber;
    private double ratePerDay;
    private boolean available = true;

    Vehicle(String vehicleNumber, double ratePerDay) {
        this.vehicleNumber = vehicleNumber;
        this.ratePerDay = ratePerDay;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public double calculatePrice(int days) {
        return ratePerDay * days;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Car extends Vehicle {
    Car(String number) {
        super(number, 2000);
    }
}

class Bike extends Vehicle {
    Bike(String number) {
        super(number, 500);
    }
}

class Customer {
    private String name;

    Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private int days;
    private boolean active = true;

    Rental(Customer customer, Vehicle vehicle, int days) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
    }

    public void returnVehicle() {
        if (active) {
            vehicle.setAvailable(true);
            active = false;
            System.out.println(vehicle.getVehicleNumber()
                    + " returned successfully.");
        }
    }

    public void display() {
        System.out.println("Customer: " + customer.getName());
        System.out.println("Vehicle: " + vehicle.getVehicleNumber());
        System.out.println("Rental days: " + days);
        System.out.println("Total price: Rs. "
                + vehicle.calculatePrice(days));
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle car = new Car("CAR101");
        Vehicle bike = new Bike("BIKE101");
        Customer customer = new Customer("Aarna");
        List<Rental> rentals = new ArrayList<>();

        rentVehicle(customer, car, 3, rentals);
        rentVehicle(customer, car, 2, rentals);
        rentVehicle(customer, bike, 2, rentals);

        rentals.get(0).returnVehicle();
        rentVehicle(customer, car, 1, rentals);
    }

    static void rentVehicle(Customer customer, Vehicle vehicle,
                            int days, List<Rental> rentals) {
        if (days <= 0) {
            System.out.println("Invalid rental duration.");
            return;
        }

        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.getVehicleNumber()
                    + " is not available.");
            return;
        }

        vehicle.setAvailable(false);
        Rental rental = new Rental(customer, vehicle, days);
        rentals.add(rental);
        rental.display();
        System.out.println();
    }
}
