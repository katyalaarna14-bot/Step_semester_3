package string.assignment_problems;

public class AccessChecker {

    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("private"))
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";

        if (fieldModifier.equals("default"))
            return (accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";

        if (fieldModifier.equals("protected"))
            return (accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";

        if (fieldModifier.equals("public"))
            return "ALLOWED";

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        String result = "";

        for (String modifier : modifiers) {
            int allowed = 0, denied = 0;

            for (String[] attempt : attempts) {
                if (attempt[0].equals(modifier)) {
                    if (classifyAccess(attempt[0], attempt[1]).equals("ALLOWED"))
                        allowed++;
                    else
                        denied++;
                }
            }

            if (!result.equals(""))
                result += " | ";

            result += modifier + ": " + allowed + " allowed / " + denied + " denied";
        }

        return result;
    }
}
