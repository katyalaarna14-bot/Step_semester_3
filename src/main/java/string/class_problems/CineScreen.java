package string.class_problems;

public class CineScreen {

    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal > 0) {
            this.seatsTotal = seatsTotal;
            seatsAvailable = seatsTotal;
        }
    }

    public void bookSeat() {
        if (seatsAvailable > 0)
            seatsAvailable--;
    }

    public void cancelBooking() {
        if (seatsAvailable < seatsTotal)
            seatsAvailable++;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }
}