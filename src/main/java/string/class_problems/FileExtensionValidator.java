package string.class_problems;

public class FileExtensionValidator {

    String validateFileExtension(String filename) {

        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex == -1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);

        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {

        FileExtensionValidator obj = new FileExtensionValidator();

        System.out.println(obj.validateFileExtension("Assignment1.PDF"));
        System.out.println(obj.validateFileExtension("notes.txt"));
    }
}