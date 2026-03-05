package application.domain;

import application.domain.enums.TypeGuest;

public class Guest extends Person {

    private String placeOfOrigin;
    private TypeGuest typeGuest;

    // Constructor correcto
    public Guest(int id, String name, String lastName, String email,
                 String password, Boolean state,
                 String placeOfOrigin, TypeGuest typeGuest) {

        super(id, name, lastName, email, password, state); // 🔥 clave
        this.placeOfOrigin = placeOfOrigin;
        this.typeGuest = typeGuest;
    }

    // Getters & Setters

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public TypeGuest getTypeGuest() {
        return typeGuest;
    }

    public void setTypeGuest(TypeGuest typeGuest) {
        this.typeGuest = typeGuest;
    }
}