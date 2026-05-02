package application.domain;

public class Guest extends Person {
    private String city;

    public Guest() {}

    // Constructor completo usando atributos del padre y propios
    public Guest(int id, String firstName, String lastName, String email, String phone,
                 boolean state, String city) {
        super(id, firstName, lastName, email, phone, state); // atributos del padre
        this.city = city; // atributo propio
    }

    // Constructor reducido (solo ID, nombre y apellido)
    public Guest(int id, String firstName, String lastName) {
        super(id, firstName, lastName, null, null, true); // por defecto activo
        this.city = null; // sin ciudad por defecto
    }

    // --- Getters y Setters propios ---
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
