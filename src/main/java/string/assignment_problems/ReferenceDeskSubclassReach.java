package string.assignment_problems;

public class ReferenceDeskSubclassReach {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        if (fieldModifier.equals("private") ||
            fieldModifier.equals("default"))
            return "DENIED";

        if (fieldModifier.equals("protected")) {
            if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"))
                return "ALLOWED";
            return "DENIED";
        }

        if (fieldModifier.equals("public"))
            return "ALLOWED";

        return "DENIED";
    }

    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {
            if (classifyAccess(attempts[i][0], attempts[i][1]).equals("DENIED")) {
                return attempts[i][0] + " via " + attempts[i][1]
                        + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }
}