
package string.class_problems;

import java.util.Scanner;

public class PayrollRegisterSystem {

    static abstract class Staff {
        String name;

        Staff(String name) {
            this.name = name;
        }

        abstract int calculatePay();

        abstract String getType();

        @Override
        public String toString() {
            return "Payslip[name=" + name
                    + ", type=" + getType()
                    + ", pay=" + calculatePay() + "]";
        }
    }

    static class FullTime extends Staff {
        int salary;

        FullTime(String name, int salary) {
            super(name);
            this.salary = salary;
        }

        @Override
        int calculatePay() {
            return salary;
        }

        @Override
        String getType() {
            return "FullTime";
        }
    }

    static class PartTime extends Staff {
        int hours;
        int rate;

        PartTime(String name, int hours, int rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        int calculatePay() {
            return hours * rate;
        }

        @Override
        String getType() {
            return "PartTime";
        }
    }

    static class Intern extends Staff {
        int stipend;

        Intern(String name, int stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        int calculatePay() {
            return stipend;
        }

        @Override
        String getType() {
            return "Intern";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Staff[] staff = new Staff[n];

        int total = 0;
        int topEarner = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "FullTime":
                    staff[i] = new FullTime(name, sc.nextInt());
                    break;

                case "PartTime":
                    staff[i] = new PartTime(
                            name, sc.nextInt(), sc.nextInt());
                    break;

                case "Intern":
                    staff[i] = new Intern(name, sc.nextInt());
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Unknown staff type: " + type);
            }

            total += staff[i].calculatePay();

            if (i == 0 || staff[i].calculatePay()
                    > staff[topEarner].calculatePay()) {
                topEarner = i;
            }
        }

        for (Staff member : staff) {
            System.out.println(member);
        }

        System.out.println("Total " + total);
        System.out.println("top earner " + staff[topEarner].name);

        sc.close();
    }
}
