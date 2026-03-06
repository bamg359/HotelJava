package application.domain;

import java.util.List;
import java.util.Scanner;

public class Booking {

    Scanner sc = new Scanner(System.in);

    int bookingId;
    String fecha;
    int cantidad;
    BedRoom bedRoom;
    Guest guest;
    Service service;



    public Booking(int bookingId, String fecha, int cantidad, BedRoom bedRoom, Guest guest, Service service) {
        this.bookingId = bookingId;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.bedRoom = bedRoom;
        this.guest = guest;
        this.service = service;
    }

    public Booking() {

    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BedRoom getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(BedRoom bedRoom) {
        this.bedRoom = bedRoom;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Booking create(Booking booking) {

        System.out.println("Ingresa el id del Booking");
        int id = sc.nextInt();
        booking.setBookingId(id);
        sc.nextLine();

        System.out.println("Ingresa la fecha");
        String fecha = sc.nextLine();
        booking.setFecha(fecha);

        System.out.println("Ingresa la cantidad");
        int cantidad = sc.nextInt();
        booking.setCantidad(cantidad);

        System.out.println("Ingresa el cuarto");
        int cuarto = sc.nextInt();
        booking.setBedRoom(new BedRoom());

        System.out.println("Ingrese el usuario");
        int usuario = sc.nextInt();
        booking.setGuest(new Guest());

        System.out.println("Ingresa el servicio");
        int servicio = sc.nextInt();
        booking.setService(new Service());

        return booking;
    }

    public List<Booking> getAll(List<Booking> bookingList) {
        return bookingList;
    }

    public void getById(int id, Booking booking) {

        if(this.bookingId == id){
            System.out.println("Id:" + booking.bookingId + "\n" +
                    "Fecha: " + booking.fecha + "\n" +
                    "Cantidad: " + booking.cantidad + "\n" +
                    "Cuarto: " + booking.bedRoom + "\n" +
                    "Usuario: " + booking.guest + "\n" +
                    "Servicio: " + booking.service + "\n");
        }else{
            System.out.println("Valide el id de la reserva que esta consultando");
        }
    }

    public void update(Booking productoEditado) {
    }

    public void delete(int id) {
    }

}
