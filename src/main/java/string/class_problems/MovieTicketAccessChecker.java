package string.class_problems;

public class MovieTicketAccessChecker {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        if (fieldModifier.equals("private"))
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";

        if (fieldModifier.equals("default"))
            return (accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";

        if (fieldModifier.equals("protected"))
            return (accessorContext.equals("DIFFERENT_PACKAGE")) ? "DENIED" : "ALLOWED";

        if (fieldModifier.equals("public"))
            return "ALLOWED";

        return "DENIED";
    }

    static String summarizeBatch(String[][] attempts) {

        int allowed = 0;
        int denied = 0;

        for (String[] attempt : attempts) {
            if (classifyAccess(attempt[0], attempt[1]).equals("ALLOWED"))
                allowed++;
            else
                denied++;
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }
}