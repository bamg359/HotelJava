package application.domain;

import java.util.List;
import java.util.Scanner;

public class Employee extends Person {

    Scanner sc = new Scanner(System.in);
    String rol;
    double salario;

    public Employee(int id, String name, String lastName, String email, String password, Boolean state, String rol, double salario) {
        super(id, name, lastName, email, password, state);
        this.rol = rol;
        this.salario = salario;
    }

    public Employee() {
        super();
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

    @Override
    public String toString() {
        return "Employee{" +
                "sc=" + sc +
                ", rol='" + rol + '\'' +
                ", salario=" + salario +
                '}';
    }
}
