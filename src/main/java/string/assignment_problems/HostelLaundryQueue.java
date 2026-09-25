package string.assignment_problems;

import java.util.ArrayList;
import java.util.List;

class LaundryStudent {
    private String name;

    LaundryStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class WashType {
    private String name;
    private int duration;
    private double charge;

    WashType(String name, int duration, double charge) {
        this.name = name;
        this.duration = duration;
        this.charge = charge;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public double getCharge() {
        return charge;
    }
}

class WashCycle {
    private LaundryStudent student;
    private WashType type;
    private String status = "QUEUED";

    WashCycle(LaundryStudent student, WashType type) {
        this.student = student;
        this.type = type;
    }

    public void start() {
        if (status.equals("QUEUED")) {
            status = "IN PROGRESS";
            System.out.println(student.getName() + "'s "
                    + type.getName() + " wash started.");
        }
    }

    public void complete() {
        if (status.equals("IN PROGRESS")) {
            status = "COMPLETED";
            System.out.println(student.getName()
                    + "'s wash completed.");
        }
    }

    public String getStatus() {
        return status;
    }

    public WashType getType() {
        return type;
    }
}

class WashingMachine {
    private int machineNumber;
    private WashCycle activeCycle;

    WashingMachine(int machineNumber) {
        this.machineNumber = machineNumber;
    }

    public boolean bookWash(LaundryStudent student, WashType type) {
        if (activeCycle != null) {
            System.out.println("Machine " + machineNumber
                    + " is busy.");
            return false;
        }

        activeCycle = new WashCycle(student, type);
        activeCycle.start();

        System.out.println("Duration: " + type.getDuration()
                + " minutes");
        System.out.println("Charge: Rs. " + type.getCharge());
        return true;
    }

    public void completeWash() {
        if (activeCycle == null) {
            System.out.println("Machine is not in use.");
            return;
        }

        activeCycle.complete();
        activeCycle = null;
        System.out.println("Machine " + machineNumber
                + " is available.");
    }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {
        LaundryStudent student1 = new LaundryStudent("Aarna");
        LaundryStudent student2 = new LaundryStudent("Vanshika");

        WashType quick = new WashType("Quick", 30, 20);
        WashType normal = new WashType("Normal", 45, 30);
        WashType heavy = new WashType("Heavy", 60, 45);

        WashingMachine machine = new WashingMachine(1);

        machine.bookWash(student1, quick);
        machine.bookWash(student2, normal);

        machine.completeWash();

        machine.bookWash(student2, heavy);
        machine.completeWash();
    }
}