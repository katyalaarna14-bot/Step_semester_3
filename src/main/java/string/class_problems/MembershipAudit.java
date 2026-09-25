package string.class_problems;

public class MembershipAudit {

    static String processNightlyAudit(LibraryMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;

        for (LibraryMember member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof FacultyMember)
                faculty++;
            else
                regular++;
        }

        return processed + " processed | " +
               nullSkipped + " null skipped | " +
               faculty + " faculty | " +
               regular + " regular";
    }
}