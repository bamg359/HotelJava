package application.domain;


import java.util.List;

public class Employ extends Person {

    // Employ attributes

    private Person person;
    private int rolId;
    private float salary;

    // Constructors

    public Employ() {
    }

    public Employ(Person person, int rolId, float salary) {
        this.person = person;
        this.rolId = rolId;
        this.salary = salary;
    }

    public Employ(int id, String name, String lastName, String email, String password, Boolean state, int rolId, float salary) {
        this.person = new Person(id, name, lastName, email, password, state);
        this.rolId = rolId;
        this.salary = salary;
    }

    // Getters and Setters

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    // Class Methods

    public Employ createEmploy(Employ employ) {
        return employ;
    }


    public Employ updateEmploy(Employ employ) {
        return employ;
    }

    public List<Employ> getAllEmploys() {
        return null;
    }

    public Employ getEmployById(int id) {
        return null;
    }

    public void deleteEmploy(int id) {
    }

}