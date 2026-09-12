package string.class_problems;

class BookingReceipt {

    private final String memberId;
    private final String[] seatNumbers;

    public BookingReceipt(String memberId, String[] seatNumbers) {
        this.memberId = memberId;
        this.seatNumbers = seatNumbers.clone();
    }

    public String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] copy = seatNumbers.clone();
        copy[index] = newSeat;
        return new BookingReceipt(memberId, copy);
    }
}

class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(String memberId, String[] seatNumbers, int groupSize) {
        super(memberId, seatNumbers);
        this.groupSize = groupSize;
    }
}

public class BookingReceiptProcessor {

    static String processNightlySettlement(BookingReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int regular = 0;

        for (BookingReceipt r : receipts) {

            if (r == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (r instanceof GroupBookingReceipt)
                group++;
            else
                regular++;
        }

        return processed + " processed | " +
               nullSkipped + " null skipped | " +
               group + " group | " +
               regular + " regular";
    }
}