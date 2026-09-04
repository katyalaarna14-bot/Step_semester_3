package string.class_problems;

public class CSVStudentRecordParser {

    public static void parseStudentRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println(
                "Name: " + fields[0] +
                " | Roll No: " + fields[1] +
                " | Dept: " + fields[2]
            );
        }
    }

    public static void main(String[] args) {

        String csvLine = "Aarna Katyal,RA2511003012398,CSE";

        parseStudentRecord(csvLine);
    }
}