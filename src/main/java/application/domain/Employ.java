package application.domain;


import java.util.List;
import java.util.Scanner;

public class Employ extends Person {

    // Employ attributes

    private Person person;
    private String rol;
    private float salary;

    // Constructors

    public Employ() {
    }

    public Employ(Person person, String rol, float salary) {
        this.person = person;
        this.rol = rol;
        this.salary = salary;
    }

    public Employ(int id, String name, String lastName, String email, String password, Boolean state, String rol, float salary) {
        this.person = new Person(id, name, lastName, email, password, state);
        this.rol = rol;
        this.salary = salary;
    }

    // Getters and Setters

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    // Class Methods

    public Employ createEmploy(Employ employ) {
         Scanner sc = new Scanner(System.in);

        Person person = new Person();
        person.createPerson(person);

        System.out.println("Ingrese el rol del empleado (Camarero, Recepcionista, Gerente)");
        String rol = sc.nextLine();
        employ.setRol(rol);
        sc.nextLine();

        System.out.println("Ingrese el salario del empleado");
        float salary = sc.nextFloat();
        employ.setSalary(salary);
        sc.nextLine();

        return employ;
    }

    public Employ updateEmploy(Employ employ) {
        return employ;
    }

    public List<Employ> getAllEmploys() {
        return null;
    }

    public void getEmployById(int id, Employ employ) {
        if(this.getPerson().getId() == id){
            System.out.println("ID: " + employ.getPerson().getId());
            System.out.println("Nombre: " + employ.getPerson().getName());
            System.out.println("Apellido: " + employ.getPerson().getLastName());
            System.out.println("Email: " + employ.getPerson().getEmail());
            System.out.println("Rol: " + employ.rol);
            System.out.println("Salario: " + employ.salary);
        }else {
            System.out.println("No se encontró el empleado con ID: " + id);
        }
    }

    public void deleteEmploy(int id) {

    }

}