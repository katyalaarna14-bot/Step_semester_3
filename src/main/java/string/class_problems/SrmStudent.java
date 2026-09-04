package string.class_problems;

public class SrmStudent {

    static String collegeName;
    static String academicYear;

    String studentName;

    static {
        collegeName = "SRM";
        academicYear = "2026-27";
        System.out.println("College info loaded");
    }

    public SrmStudent(String studentName) {
        this.studentName = studentName;
    }

    public static void main(String[] args) {

        String[] names = {
            "Ravi",
            "Meera",
            "Karthik",
            "Divya",
            "Anitha"
        };

        for (int i = 0; i < names.length; i++) {

            SrmStudent student =
                    new SrmStudent(names[i]);

            System.out.println(
                "Student record created: "
                + student.studentName
            );
        }
    }
}
