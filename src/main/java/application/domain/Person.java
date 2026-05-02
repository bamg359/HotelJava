package application.domain;

public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean state;

    public Person() {}

    public Person(int id, String firstName, String lastName, String email, String phone, boolean state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.state = state;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public boolean getState() { return state; }
    public void setState(boolean state) { this.state = state; }

    // Métodos auxiliares
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getStateText() {
        return state ? "ACTIVO" : "INACTIVO";
    }
}

