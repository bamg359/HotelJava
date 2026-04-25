package application.domain;

import application.domain.enums.GuestState;
import application.domain.enums.GuestType;

public class Guest extends Person {
    private String city;
    private GuestType type;

    public Guest() {}

    // Constructor completo usando atributos del padre y propios
    public Guest(int id, String firstName, String lastName, String email, String phone,
                 GuestState state, String city, GuestType type) {
        super(id, firstName, lastName, email, phone, state); // usa el enum GuestState
        this.city = city;
        this.type = type;
    }

    // Constructor reducido (solo ID, nombre y apellido)
    public Guest(int id, String firstName, String lastName) {
        super(id, firstName, lastName, null, null, GuestState.ACTIVE); // por defecto ACTIVO
        this.city = null;
        this.type = GuestType.NEW; // valor por defecto
    }

    // --- Getters y Setters propios ---
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public GuestType getType() { return type; }
    public void setType(GuestType type) { this.type = type; }
}
