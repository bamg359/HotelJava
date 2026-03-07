package application.domain;

import application.domain.enums.TypeGuest;

public class Guest extends Person {
    private String placeOfOring;
    private TypeGuest typeGuest;


    // constructor


    public Guest(String placeOfOring, TypeGuest typeGuest) {
        this.placeOfOring = placeOfOring;
        this.typeGuest = typeGuest;
    }

    public Guest(String email, String placeOfOring, TypeGuest typeGuest) {
        super(email);
        this.placeOfOring = placeOfOring;
        this.typeGuest = typeGuest;
    }

    public Guest(int id, String name, String lastName, String email, String password, Boolean state, String placeOfOring, TypeGuest typeGuest) {
        super(id, name, lastName, email, password, state);
        this.placeOfOring = placeOfOring;
        this.typeGuest = typeGuest;
    }
}
