package application.repository;

import application.domain.Person;

import java.util.List;
import java.util.Scanner;

public class EmployRepository {

    Scanner sc = new Scanner(System.in);

    Person person;
    String rol;
    double salario;

    public EmployRepository(Person person, String rol, double salario) {
        this.person = person;
        this.rol = rol;
        this.salario = salario;
    }

    public EmployRepository() {

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

    public EmployRepository create(EmployRepository employ) {

        return employ;
    }

    public List<EmployRepository> getAll(List<EmployRepository> employList) {
        return employList;
    }

    public void getById(int id, EmployRepository employ) {
    }

    public void update(EmployRepository productoEditado) {
    }

    public void delete(int id) {
    }
}
