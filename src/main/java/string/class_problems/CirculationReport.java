package string.class_problems;

public class CirculationReport {

    static String batchPrint(LibraryMember[] members) {

        StringBuilder report = new StringBuilder();

        for (LibraryMember member : members) {

            report.append(member.displayInfo());

            if (member instanceof StudentMember) {
                StudentMember student = (StudentMember) member;

                report.append(" [Course via downcast: ")
                      .append(student.getCourse())
                      .append("]");
            }

            report.append(" | ");
        }

        return report.toString();
    }
}