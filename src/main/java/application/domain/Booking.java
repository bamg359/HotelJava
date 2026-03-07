package application.domain;

import java.util.Scanner;

public class Booking {

    Scanner sc = new Scanner(System.in);

    // Booking Attributes
    private int id;
    private String dateIn;
    private String dateOut;
    private String state;
    private Float totalPrice;
    private int bedRoomId;
    private int guestId;

    // Constructors
    public Booking() {
    }

    public Booking(int id, String dateIn, String dateOut, String state, Float totalPrice, int bedRoomId, int guestId) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.state = state;
        this.totalPrice = totalPrice;
        this.bedRoomId = bedRoomId;
        this.guestId = guestId;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getBedRoomId() {
        return bedRoomId;
    }

    public void setBedRoomId(int bedRoomId) {
        this.bedRoomId = bedRoomId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    // Class Methods

    public Booking createBooking(Booking booking) {

        System.out.println("Ingrese el id de la reserva");
        int id = sc.nextInt();
        booking.setId(id);
        sc.nextLine();

        System.out.println("Ingrese la fecha de ingreso");
        String dateIn = sc.nextLine();
        booking.setDateIn(dateIn);

        System.out.println("Ingrese la fecha de salida");
        String dateOut = sc.nextLine();
        booking.setDateOut(dateOut);

        System.out.println("Ingrese el estado de la reserva");
        String state = sc.nextLine();
        booking.setState(state);

        System.out.println("Ingrese el precio total de la reserva");
        Float totalPrice = sc.nextFloat();
        booking.setTotalPrice(totalPrice);
        sc.nextLine();

        System.out.println("Ingrese el id de la habitación");
        int bedRoomId = sc.nextInt();
        booking.setBedRoomId(bedRoomId);
        sc.nextLine();

        System.out.println("Ingrese el id del huesped");
        int guestId = sc.nextInt();
        booking.setGuestId(guestId);
        sc.nextLine();

        return booking;
    }

    public Booking updateBooking(Booking booking) {
        return booking;
    }

    public void getBookingById(int id, Booking booking) {
        if (this.id == id) {
            System.out.println("Id:" + booking.id + "\n" +
                    "Fecha de ingreso: " + booking.dateIn + "\n" +
                    "Fecha de salida: " + booking.dateOut + "\n" +
                    "Precio" + booking.totalPrice + "\n" +
                    "Estado:" + booking.state + "\n"+
                    "Habitacion:" + booking.bedRoomId + "\n"+
                    "Huesped:" + booking.state);

        } else {
            System.out.println("Booking no encontrado");
        }
    }

    public Booking getAllBookings() {
        return null;
    }
}
