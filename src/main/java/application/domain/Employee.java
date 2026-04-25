package application.domain;

import application.domain.enums.PersonState;

public class Employee extends Person {
    private String position;
    private double salary;

    public Employee() {}


    public Employee(int id, String firstName, String lastName, String email, String phone,
                    PersonState state, String position, double salary) {
        super(id, firstName, lastName, email, phone, state);
        this.position = position;
        this.salary = salary;
    }


    public Employee(int id, String firstName, String lastName) {
        super(id, firstName, lastName, null, null, PersonState.ACTIVE); // por defecto ACTIVO
        this.position = "General";
        this.salary = 0.0;
    }

    // --- Getters y Setters propios ---
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
