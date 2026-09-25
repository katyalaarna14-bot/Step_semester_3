package string.class_problems;

interface Printable {

    String printLabel();
}

class PackageBox implements Printable {

    private String trackingId;

    public PackageBox(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String printLabel() {
        return "Package Label | Tracking ID: " + trackingId;
    }
}

class Invoice implements Printable {

    private String invoiceNumber;

    public Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String printLabel() {
        return "Invoice Label | Invoice No: " + invoiceNumber;
    }
}

public class WarehouseLabelPrinter {

    static String printAll(Printable[] items) {

        StringBuilder result = new StringBuilder();

        for (Printable item : items) {
            result.append(item.printLabel()).append(" | ");
        }

        return result.toString();
    }
}