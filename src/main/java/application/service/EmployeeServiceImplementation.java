package application.service;

import application.domain.Employee;

import java.util.Optional;
import java.util.Scanner;

public class EmployeeServiceImplementation implements EmployeeService{

    Scanner sc = new Scanner(System.in);

    @Override
    public Employee createEmployee(Employee employee) {

        System.out.println("Ingrese el id del huesped");
        int id = sc.nextInt();
        employee.setId(id);

        System.out.println("Ingrese el nombre");
        String name = sc.next();
        employee.setName(name);

        System.out.println("Ingrese el apellido");
        String lastName = sc.next();
        employee.setLastName(lastName);

        System.out.println("Ingrese el email");
        String email = sc.next();
        employee.setEmail(email);

        System.out.println("Ingrese la contraseña");
        String password = sc.next();
        employee.setPassword(password);

        employee.setState(true);

        System.out.println("Ingrese el rol");
        String rol = sc.next();
        employee.setRol(rol);

        System.out.println("Ingrese el salario");
        double salario = sc.nextDouble();
        employee.setSalario(salario);

        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return Optional.empty();
    }
}
