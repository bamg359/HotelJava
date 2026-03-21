package application.view;

import application.domain.Employee;
import application.domain.Guest;
import application.domain.Person;
import application.service.EmployeeServiceImplementation;
import application.service.GuestServiceImplementation;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {

    private final EmployeeServiceImplementation employeeServiceImplementation;

    private final Employee employee;

    public EmployeeView(EmployeeServiceImplementation employeeServiceImplementation, Employee employee) {
        this.employeeServiceImplementation = employeeServiceImplementation;
        this.employee = employee;
    }


    public void createEmployee(){

        employeeServiceImplementation.createEmployee(employee);

    }


}
