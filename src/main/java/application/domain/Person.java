package application.domain;

import java.util.List;
import java.util.Scanner;

public class Person {

    Scanner sc = new Scanner(System.in);

    // Person Atributes

    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Boolean state;


    // Constructors

    public Person() {
    }

    public Person(String email){
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

    public int getId(){
        return id;
    }

    public void setId(int id){
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

    public Person createUser(Person person){
        System.out.println("Ingrese el id de la persona");
        int id = sc.nextInt();
        person.id = id;
        sc.nextLine();

        System.out.println("Ingrese el nombre");
        String name = sc.nextLine();
        person.name = name;

        System.out.println("Ingrese el apellido");
        String lastName = sc.nextLine();
        person.lastName = lastName;

        System.out.println("Ingrese el email");
        String email = sc.nextLine();
        person.email = email;

        System.out.println("Ingrese la contraseña");
        String password = sc.nextLine();
        person.password = password;

        System.out.println("Ingrese el estado (true/false)");
        boolean state = sc.nextBoolean();
        person.state = state;

        return person;
    }


    public Person updateUser(Person person){


        return person;
    }

    public List<Person> getUsers(){
        return null;
    }

    public void getUserById(int id){
        if(this.id == id){
            System.out.println("Id: " + this.id + "\n" +
                    "Nombre: " + this.name + "\n" +
                    "Apellido: " + this.lastName + "\n" +
                    "Email: " + this.email + "\n" +
                    "Estado: " + this.state + "\n");
        }else{
            System.out.println("Valide el id de la persona que esta consultando");
        }
    }

    public void deleteUser(int id){

        }




}
