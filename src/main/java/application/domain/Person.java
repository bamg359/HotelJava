package application.domain;

import java.util.List;
import java.util.Scanner;

public class Person {

    Scanner sc = new Scanner(System.in);

    // Person Attributes

    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Boolean state;

    // Constructors

    public Person() {
    }

    public Person(String email) {
        this.email = email;
    }

    public Person(int id, String name, String lastName, String email, String password, Boolean state) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.state = state;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    double number = 0.0;

    // Class Methods

    public Person createPerson(Person person) {

        int id = sc.nextInt();
        person.setId(id);
        sc.nextLine();

        System.out.println("Ingrese el nombre");
        String nombre = sc.nextLine();
        person.setName(nombre);
        System.out.println("Ingrese el apellido");
        String apellido = sc.nextLine();
        person.setLastName(apellido);
        System.out.println("Ingrese el email");
        String email = sc.nextLine();
        person.setEmail(email);
        System.out.println("Ingrese la contraseña");
        String password = sc.nextLine();
        person.setPassword(password);
        person.setState(true);

        return person;
    }

    public Person updateUser(Person person) {
        return person;
    }

    public List<Person> getUsers() {
        return null;
    }

    public void getUserById(int id, Guest guest) {
        if (guest.getPerson().getId() == id) {
            System.out.println(
                    "Id:" + guest.getPerson().getId() + "\n" +
                            "Nombre:" + guest.getPerson().getName() + "\n" +
                            "Apellido:" + guest.getPerson().getLastName() + "\n" +
                            "Correo:" + guest.getPerson().getEmail() + "\n" +
                            "Estado: " + guest.getPerson().getState()
            );
        } else {
            System.out.println("Valide el id del huespet que esta consultando");
        }
    }

    public void deleteUser(int id) {

    }

}
