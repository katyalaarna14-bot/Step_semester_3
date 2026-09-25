package string.assignment_problems;

import java.util.*;

class NoticeStudent {
    private String name;
    private String department;
    private List<NotificationChannel> channels;

    public NoticeStudent(String name, String department,
                         List<NotificationChannel> channels) {
        this.name = name;
        this.department = department;
        this.channels = channels;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<NotificationChannel> getChannels() {
        return channels;
    }
}

interface NotificationChannel {
    void send(NoticeStudent student, String title, String message);
}

class EmailNotification implements NotificationChannel {
    public void send(NoticeStudent student, String title, String message) {
        System.out.println("Email sent to " + student.getName()
                + ": " + title);
    }
}

class SMSNotification implements NotificationChannel {
    public void send(NoticeStudent student, String title, String message) {
        System.out.println("SMS sent to " + student.getName()
                + ": " + title);
    }
}

class AppNotification implements NotificationChannel {
    public void send(NoticeStudent student, String title, String message) {
        System.out.println("App notification sent to "
                + student.getName() + ": " + title);
    }
}

class CampusNotice {
    private String title;
    private String message;
    private Set<String> targetDepartments;

    public CampusNotice(String title, String message,
                        Set<String> targetDepartments) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Notice title is required.");
        }

        if (targetDepartments == null || targetDepartments.isEmpty()) {
            throw new IllegalArgumentException(
                    "At least one target department is required.");
        }

        this.title = title;
        this.message = message;
        this.targetDepartments = new HashSet<>(targetDepartments);
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Set<String> getTargetDepartments() {
        return Collections.unmodifiableSet(targetDepartments);
    }
}

class NoticeBoard {
    private List<NoticeStudent> students = new ArrayList<>();

    public void addStudent(NoticeStudent student) {
        students.add(student);
    }

    public void dispatch(CampusNotice notice) {
        System.out.println("Dispatching notice: " + notice.getTitle());

        for (NoticeStudent student : students) {
            if (notice.getTargetDepartments()
                    .contains(student.getDepartment())) {

                for (NotificationChannel channel : student.getChannels()) {
                    channel.send(student, notice.getTitle(),
                            notice.getMessage());
                }
            }
        }
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NotificationChannel email = new EmailNotification();
        NotificationChannel sms = new SMSNotification();
        NotificationChannel app = new AppNotification();

        NoticeBoard board = new NoticeBoard();

        board.addStudent(new NoticeStudent(
                "Aarna", "CSE", Arrays.asList(email, app)));

        board.addStudent(new NoticeStudent(
                "Vanshika", "ECE", Arrays.asList(sms)));

        board.addStudent(new NoticeStudent(
                "Rahul", "MECH", Arrays.asList(email)));

        CampusNotice notice = new CampusNotice(
                "Hackathon Registration",
                "Register before Friday.",
                new HashSet<>(Arrays.asList("CSE", "ECE")));

        board.dispatch(notice);
    }
}