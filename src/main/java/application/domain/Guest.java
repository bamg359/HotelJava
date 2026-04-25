package application.domain;

import application.domain.enums.GuestType;
import application.domain.enums.PersonState;

public class Guest extends Person {
    private String city;
    private GuestType type;

    public Guest() {}

    // Constructor completo usando atributos del padre y propios
    public Guest(int id, String firstName, String lastName, String email, String phone,
                 PersonState state, String city, GuestType type) {
        super(id, firstName, lastName, email, phone, state); // usa el enum GuestState
        this.city = city;
        this.type = type;
    }


    public Guest(int id, String firstName, String lastName, String email, String phone,
                 PersonState state, GuestType type, String city) {
        super(id, firstName, lastName, email, phone, state);
        this.type = type;   // ✅ guardas el enum
        this.city = city;
    }

    // --- Getters y Setters propios ---
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public GuestType getType() { return type; }
    public void setType(GuestType type) { this.type = type; }
}
