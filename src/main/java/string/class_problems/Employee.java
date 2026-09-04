package string.class_problems;

public class Employee {

    String employeeId;
    double salary;

    public Employee(String employeeId, double salary) {
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public static void main(String[] args) {

        Employee[] employees = {
            new Employee("E-101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E-104", 48000)
        };

        for (int i = 0; i < employees.length; i++) {

            employees[i].raiseSalary(5000);

            System.out.println(
                employees[i].employeeId
                + " | Final Salary: Rs "
                + employees[i].salary
            );
        }
    }
}