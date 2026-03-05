package application.domain;

import java.util.List;

public class Guest {

    // Guest Attributes
    
    private Person person;
    private String origin;
    private int guestType;

    // Constructors
    
    public Guest() {
    }

    public Guest(Person person, String origin, int guestType) {
        this.person = person;
        this.origin = origin;
        this.guestType = guestType;
    }

    public Guest(int id, String name, String lastName, String email, String password, Boolean state, String origin, int guestType) {
        this.person = new Person(id, name, lastName, email, password, state);
        this.origin = origin;
        this.guestType = guestType;
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

    public int getGuestType() {
        return guestType;
    }

    public void setGuestType(int guestType) {
        this.guestType = guestType;
    }

    // Class Methods

    public Guest createGuest(Guest guest) {
        return guest;
    }


    public Guest updateGuest(Guest guest) {
        return guest;
    }

    public List<Guest> getAllGuests() {
        return null;
    }

    public Guest getGuestById(int id) {
        return null;
    }

    public void deleteGuest(int id) {
    }

}
