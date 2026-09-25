package string.class_problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

abstract class Room {
    private int roomNumber;
    private double pricePerNight;

    Room(int roomNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double calculatePrice(long nights) {
        return pricePerNight * nights;
    }
}

class StandardRoom extends Room {
    StandardRoom(int number) {
        super(number, 2000);
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(int number) {
        super(number, 3500);
    }
}

class HotelCustomer {
    private String name;

    HotelCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Reservation {
    private HotelCustomer customer;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private boolean active = true;

    Reservation(HotelCustomer customer, Room room,
                LocalDate checkIn, LocalDate checkOut) {
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public boolean overlaps(LocalDate start, LocalDate end) {
        return active && start.isBefore(checkOut)
                && end.isAfter(checkIn);
    }

    public int getRoomNumber() {
        return room.getRoomNumber();
    }

    public void cancel() {
        if (active) {
            active = false;
            System.out.println("Reservation cancelled.");
        } else {
            System.out.println("Reservation is already inactive.");
        }
    }

    public void display() {
        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Room: " + room.getRoomNumber());
        System.out.println("Nights: " + nights);
        System.out.println("Total price: Rs. "
                + room.calculatePrice(nights));
    }
}

class Hotel {
    private List<Reservation> reservations = new ArrayList<>();

    public void bookRoom(HotelCustomer customer, Room room,
                         LocalDate checkIn, LocalDate checkOut) {
        if (checkIn == null || checkOut == null
                || !checkOut.isAfter(checkIn)) {
            System.out.println("Invalid booking dates.");
            return;
        }

        for (Reservation reservation : reservations) {
            if (reservation.getRoomNumber() == room.getRoomNumber()
                    && reservation.overlaps(checkIn, checkOut)) {
                System.out.println("Room "
                        + room.getRoomNumber()
                        + " is already booked for these dates.");
                return;
            }
        }

        Reservation reservation =
                new Reservation(customer, room, checkIn, checkOut);
        reservations.add(reservation);
        reservation.display();
        System.out.println();
    }
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        Room standard = new StandardRoom(101);
        Room deluxe = new DeluxeRoom(201);
        HotelCustomer customer = new HotelCustomer("Aarna");

        LocalDate checkIn = LocalDate.of(2026, 11, 10);
        LocalDate checkOut = LocalDate.of(2026, 11, 13);

        hotel.bookRoom(customer, standard, checkIn, checkOut);

        hotel.bookRoom(customer, standard,
                LocalDate.of(2026, 11, 12),
                LocalDate.of(2026, 11, 15));

        hotel.bookRoom(customer, deluxe, checkIn, checkOut);
    }
}