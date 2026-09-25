package string.assignment_problems;

public class AttendanceAnnouncer {

    static String batchPrint(GymMember[] members) {

        StringBuilder report = new StringBuilder();

        for (GymMember member : members) {

            report.append(member.displayInfo());

            if (member instanceof PremiumMember) {
                PremiumMember premium = (PremiumMember) member;

                report.append(" [Trainer via downcast: ")
                      .append(premium.getTrainerName())
                      .append("]");
            }

            report.append(" | ");
        }

        return report.toString();
    }
}