package string.class_problems;

abstract class DeliveryNote {

    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {
        return confirmDelivery() + " | Signed by: " + signature;
    }
}

class ParcelNote extends DeliveryNote {

    @Override
    public String confirmDelivery() {
        return "Parcel delivered successfully";
    }
}

class LetterNote extends DeliveryNote {

    @Override
    public String confirmDelivery() {
        return "Letter delivered successfully";
    }
}

public class PackageDropOff {

    static String logAll(DeliveryNote[] notes) {

        StringBuilder result = new StringBuilder();

        for (DeliveryNote note : notes) {
            result.append(note.confirmDelivery()).append(" | ");
        }

        return result.toString();
    }
}