package string.assignment_problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class PortalStudent {
    private String name;

    PortalStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

abstract class PortalAssignment {
    private String title;
    private LocalDate deadline;

    PortalAssignment(String title, LocalDate deadline) {
        this.title = title;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public long getLateDays(LocalDate submissionDate) {
        return Math.max(0,
                ChronoUnit.DAYS.between(deadline, submissionDate));
    }

    public abstract double calculatePenalty(double marks, long lateDays);
}

class CodingAssignment extends PortalAssignment {
    CodingAssignment(String title, LocalDate deadline) {
        super(title, deadline);
    }

    public double calculatePenalty(double marks, long lateDays) {
        return marks * 0.10 * lateDays;
    }
}

class WrittenAssignment extends PortalAssignment {
    WrittenAssignment(String title, LocalDate deadline) {
        super(title, deadline);
    }

    public double calculatePenalty(double marks, long lateDays) {
        return marks * 0.20 * lateDays;
    }
}

class AssignmentSubmission {
    private PortalStudent student;
    private PortalAssignment assignment;
    private LocalDate submissionDate;
    private String status = "SUBMITTED";
    private double finalMarks = 0;

    AssignmentSubmission(PortalStudent student,
                         PortalAssignment assignment,
                         LocalDate submissionDate) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
    }

    public void grade(double awardedMarks) {
        if (!status.equals("SUBMITTED")) {
            System.out.println("Submission already graded.");
            return;
        }

        if (awardedMarks < 0 || awardedMarks > 100) {
            System.out.println("Invalid marks.");
            return;
        }

        long lateDays = assignment.getLateDays(submissionDate);
        double penalty =
                assignment.calculatePenalty(awardedMarks, lateDays);

        finalMarks = Math.max(0, awardedMarks - penalty);
        status = "GRADED";

        System.out.println("Student: " + student.getName());
        System.out.println("Assignment: " + assignment.getTitle());
        System.out.println("Late days: " + lateDays);
        System.out.println("Penalty: " + penalty);
        System.out.println("Final marks: " + finalMarks);
        System.out.println("Status: " + status);
        System.out.println();
    }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        PortalStudent student = new PortalStudent("Aarna");

        LocalDate deadline = LocalDate.of(2026, 10, 5);
        LocalDate submitted = LocalDate.of(2026, 10, 7);

        PortalAssignment coding =
                new CodingAssignment("Java Project", deadline);

        PortalAssignment written =
                new WrittenAssignment("Theory Report", deadline);

        AssignmentSubmission first =
                new AssignmentSubmission(student, coding, submitted);
        first.grade(80);
        first.grade(90);

        AssignmentSubmission second =
                new AssignmentSubmission(student, written, submitted);
        second.grade(80);
    }
}