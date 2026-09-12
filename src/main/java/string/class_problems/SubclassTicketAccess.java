package string.class_problems;

public class SubclassTicketAccess {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        if (fieldModifier.equals("private") ||
            fieldModifier.equals("default"))
            return "DENIED";

        if (fieldModifier.equals("protected"))
            return accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")
                    ? "ALLOWED" : "DENIED";

        if (fieldModifier.equals("public"))
            return "ALLOWED";

        return "DENIED";
    }
}