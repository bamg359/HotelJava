package application.domain;

import java.util.List;
import java.util.Scanner;

public class Employ {

    Scanner sc = new Scanner(System.in);

    Person person;
    String rol;
    double salario;

    public Employ(Person person, String rol, double salario) {
        this.person = person;
        this.rol = rol;
        this.salario = salario;
    }

    public Employ() {

    }

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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Employ create(Employ employ) {
        System.out.println("Creando persona para el empleado");
        Person person = new Person();
        employ.person = person.createUser(person);

        System.out.println("Ingrese el rol del empleado");
        String rol = sc.nextLine();
        employ.rol = rol;

        System.out.println("Ingrese el salario del empleado");
        double salario = sc.nextDouble();
        employ.salario = salario;

        return employ;
    }

    public List<Employ> getAll(List<Employ> employList) {
        return employList;
    }

    public void getById(int id, Employ employ) {
        if(employ.person.getId() == id){
            System.out.println("Id: " + employ.person.getId() + "\n" +
                    "Nombre: " + employ.person.getName() + "\n" +
                    "Apellido: " + employ.person.getLastName() + "\n" +
                    "Email: " + employ.person.getEmail() + "\n" +
                    "Rol: " + employ.rol + "\n" +
                    "Salario: " + employ.salario + "\n");
        }else{
            System.out.println("Valide el id del empleado que esta consultando");
        }
    }

    public void update(Employ productoEditado) {
    }

    public void delete(int id) {
    }
}
