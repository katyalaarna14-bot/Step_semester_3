package string.assignment_problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PremiereCustomer {
    private String name;

    PremiereCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Seat {
    private String seatNumber;
    private String type;
    private double price;

    Seat(String seatNumber, String type, double price) {
        this.seatNumber = seatNumber;
        this.type = type;
        this.price = price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }
}

class PremiereShow {
    private String title;
    private Set<String> bookedSeats = new HashSet<>();

    PremiereShow(String title) {
        this.title = title;
    }

    public boolean isAvailable(Seat seat) {
        return !bookedSeats.contains(seat.getSeatNumber());
    }

    public void bookSeat(Seat seat) {
        bookedSeats.add(seat.getSeatNumber());
    }

    public void releaseSeat(Seat seat) {
        bookedSeats.remove(seat.getSeatNumber());
    }

    public String getTitle() {
        return title;
    }
}

class PremiereBooking {
    private PremiereCustomer customer;
    private PremiereShow show;
    private List<Seat> seats;
    private boolean active = true;

    PremiereBooking(PremiereCustomer customer,
                    PremiereShow show, List<Seat> seats) {
        this.customer = customer;
        this.show = show;
        this.seats = seats;
    }

    public void cancel(boolean beforeShow) {
        if (!active) {
            System.out.println("Booking is already cancelled.");
            return;
        }

        if (!beforeShow) {
            System.out.println("Cancellation is not allowed.");
            return;
        }

        for (Seat seat : seats) {
            show.releaseSeat(seat);
        }

        active = false;
        System.out.println("Booking cancelled. Seats released.");
    }

    public void display() {
        double total = 0;
        System.out.println("Customer: " + customer.getName());
        System.out.println("Show: " + show.getTitle());

        for (Seat seat : seats) {
            System.out.println("Seat: " + seat.getSeatNumber()
                    + " - Rs. " + seat.getPrice());
            total += seat.getPrice();
        }

        System.out.println("Total: Rs. " + total);
    }
}

class PremiereTicketCounter {
    public PremiereBooking book(PremiereCustomer customer,
                               PremiereShow show,
                               List<Seat> seats) {
        if (seats.isEmpty() || seats.size() > 6) {
            System.out.println("Select between 1 and 6 seats.");
            return null;
        }

        Set<String> requested = new HashSet<>();
        for (Seat seat : seats) {
            if (!requested.add(seat.getSeatNumber())
                    || !show.isAvailable(seat)) {
                System.out.println("Seat "
                        + seat.getSeatNumber()
                        + " is already booked.");
                return null;
            }
        }

        for (Seat seat : seats) {
            show.bookSeat(seat);
        }

        PremiereBooking booking =
                new PremiereBooking(customer, show,
                        new ArrayList<>(seats));
        booking.display();
        return booking;
    }
}

public class CampusPremiere {
    public static void main(String[] args) {
        PremiereCustomer customer =
                new PremiereCustomer("Aarna");
        PremiereShow show =
                new PremiereShow("Campus Premiere");

        Seat regular = new Seat("R1", "Regular", 150);
        Seat premium = new Seat("P1", "Premium", 250);
        Seat recliner = new Seat("L1", "Recliner", 400);

        PremiereTicketCounter counter =
                new PremiereTicketCounter();

        List<Seat> firstBooking = new ArrayList<>();
        firstBooking.add(regular);
        firstBooking.add(premium);
        PremiereBooking booking =
                counter.book(customer, show, firstBooking);

        List<Seat> duplicateBooking = new ArrayList<>();
        duplicateBooking.add(regular);
        counter.book(new PremiereCustomer("Vanshika"),
                show, duplicateBooking);

        if (booking != null) {
            booking.cancel(true);
        }

        List<Seat> nextBooking = new ArrayList<>();
        nextBooking.add(regular);
        nextBooking.add(recliner);
        counter.book(new PremiereCustomer("Vanshika"),
                show, nextBooking);
    }
}