package application;

import application.domain.*;

public class Main {

    public static void main(String[] args) {

        Person person = new Person("jd@med.com");

        BedRoom bedRoom = new BedRoom();

        bedRoom.createBedRoom(bedRoom);

        bedRoom.getBedRoomById(1, bedRoom);

        Booking booking = new Booking();

        booking.create(booking);

        booking.getById(1, booking);

        Employ employ = new Employ();

        employ.create(employ);

        employ.getById(1, employ);

        Guest guest = new Guest();

        guest.create(guest);

        guest.getById(1, guest);

        Service service = new Service();

        service.create(service);

        service.getById(1, service);

    }
}
