package application.domain;

import javax.swing.*;
import java.time.LocalDate;

public class Employee extends Person {

  private String rol;
  private double salary;
  private LocalDate schedule;


    public Employee(int id, String name, String lastName, String email, String password, Boolean state, String rol, double salary, LocalDate schedule) {
        super(id, name, lastName, email, password, state);
        this.rol = rol;
        this.salary = salary;
        this.schedule = schedule;
    }
// methods


    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }
}


// constructor

