
package string.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CampusVehiclePassSystem {

    static class Vehicle {
        String passNumber;
        String ownerName;
        String type;

        Vehicle(String passNumber, String ownerName, String type) {
            this.passNumber = passNumber;
            this.ownerName = ownerName;
            this.type = type;
        }

        int getPassFee() {
            return 0;
        }

        boolean supportsCharging() {
            return false;
        }
    }

    interface Chargeable {
        boolean bookChargingBay();
    }

    static class Bike extends Vehicle {
        Bike(String passNumber, String ownerName) {
            super(passNumber, ownerName, "Bike");
        }

        @Override
        int getPassFee() {
            return 300;
        }
    }

    static class Car extends Vehicle {
        Car(String passNumber, String ownerName) {
            super(passNumber, ownerName, "Car");
        }

        @Override
        int getPassFee() {
            return 1000;
        }
    }

    static class EBike extends Vehicle implements Chargeable {
        EBike(String passNumber, String ownerName) {
            super(passNumber, ownerName, "EBike");
        }

        @Override
        int getPassFee() {
            return 300;
        }

        @Override
        public boolean bookChargingBay() {
            return true;
        }

        @Override
        boolean supportsCharging() {
            return true;
        }
    }

    static class ECar extends Vehicle implements Chargeable {
        ECar(String passNumber, String ownerName) {
            super(passNumber, ownerName, "ECar");
        }

        @Override
        int getPassFee() {
            return 1000;
        }

        @Override
        public boolean bookChargingBay() {
            return true;
        }

        @Override
        boolean supportsCharging() {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();

        while (sc.hasNext()) {
            String operation = sc.next();

            if (operation.equals("PASS")) {
                String type = sc.next();
                String passNumber = sc.next();
                String ownerName = sc.next();

                Vehicle vehicle = null;

                switch (type) {
                    case "Bike":
                        vehicle = new Bike(passNumber, ownerName);
                        break;
                    case "Car":
                        vehicle = new Car(passNumber, ownerName);
                        break;
                    case "EBike":
                        vehicle = new EBike(passNumber, ownerName);
                        break;
                    case "ECar":
                        vehicle = new ECar(passNumber, ownerName);
                        break;
                }

                if (vehicle != null) {
                    vehicles.put(passNumber, vehicle);
                    System.out.println(passNumber + " (" + type
                            + ") pass fee " + vehicle.getPassFee());
                }

            } else if (operation.equals("CHARGE")) {
                String passNumber = sc.next();

                Vehicle vehicle = vehicles.get(passNumber);

                if (vehicle == null) {
                    System.out.println("Vehicle not found");
                } else if (vehicle instanceof Chargeable) {
                    Chargeable chargeable = (Chargeable) vehicle;

                    if (chargeable.bookChargingBay()) {
                        System.out.println(passNumber
                                + " charging bay allotted");
                    }
                } else {
                    System.out.println(passNumber
                            + " rejected: charging unsupported");
                }
            }
        }

        sc.close();
    }
}
