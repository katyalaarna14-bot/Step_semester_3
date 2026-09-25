package string.class_problems;

enum LeaveStatus {
    PENDING, APPROVED, REJECTED
}

class Employee {
    private String name;
    private int maxLeaveDays;

    Employee(String name, int maxLeaveDays) {
        this.name = name;
        this.maxLeaveDays = maxLeaveDays;
    }

    public String getName() {
        return name;
    }

    public int getMaxLeaveDays() {
        return maxLeaveDays;
    }
}

class LeaveRequest {
    private Employee employee;
    private int days;
    private LeaveStatus status = LeaveStatus.PENDING;

    LeaveRequest(Employee employee, int days) {
        this.employee = employee;
        this.days = days;
    }

    public void review(boolean approve) {
        if (status != LeaveStatus.PENDING) {
            System.out.println("Request already reviewed.");
            return;
        }

        if (days <= 0 || days > employee.getMaxLeaveDays()) {
            status = LeaveStatus.REJECTED;
        } else {
            status = approve ? LeaveStatus.APPROVED
                             : LeaveStatus.REJECTED;
        }

        System.out.println(employee.getName()
                + "'s leave status: " + status);
    }

    public LeaveStatus getStatus() {
        return status;
    }
}

public class EmployeeLeaveWorkflow {
    public static void main(String[] args) {
        Employee employee = new Employee("Aarna", 10);

        LeaveRequest request = new LeaveRequest(employee, 5);
        request.review(true);
        request.review(false);

        LeaveRequest secondRequest =
                new LeaveRequest(employee, 15);
        secondRequest.review(true);
    }
}