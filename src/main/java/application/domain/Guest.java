package application.domain;

import java.util.List;
import java.util.Scanner;

public class Guest {

    Scanner sc = new Scanner(System.in);

    // Guest Attributes

    private Person person;
    private String origin;

    // Constructors

    public Guest() {
    }

    public Guest(Person person, String origin) {
        this.person = person;
        this.origin = origin;
    }

    public Guest(int id, String name, String lastName, String email, String password, Boolean state, String origin) {
        this.person = new Person(id, name, lastName, email, password, state);
        this.origin = origin;
    }

    // Getters and Setters

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    // Class Methods

    public Guest createGuest(Guest guest) {
        Person person = new Person();
        person.createPerson(person);

        System.out.println("Ingrese el origen del huesped");
        String origin = sc.nextLine();
        guest.setOrigin(origin);
        sc.nextLine();

        return guest;
    }

    public Guest updateGuest(Guest guest) {
        return guest;
    }

    public List<Guest> getAllGuests() {
        return null;
    }

    public void getGuestById(int id, Guest guest) {
        if (guest.person.getId() == id) {
            System.out.println(
                    "Id:" + guest.person.getId() + "\n" +
                            "Nombre:" + guest.person.getName() + "\n" +
                            "Apellido:" + guest.person.getLastName() + "\n" +
                            "Correo:" + guest.person.getEmail() + "\n" +
                            "Estado: " + guest.person.getState()
            );
        } else {
            System.out.println("Valide el id del huespet que esta consultando");
        }
    }

    public void deleteGuest(int id) {

    }

}
