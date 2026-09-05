package string.assigment_problems;
public class Employee {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(
            empId + " | " + empName + " | salary=" + salary + " | intern=" + isIntern
        );
    }

    public static void main(String[] args) {

        Employee permanent = new Employee(
            "E101", "Asha", 45000
        );

        Employee intern = new Employee(
            "I202", "Vikram"
        );

        permanent.printProfile();
        intern.printProfile();
    }
}
