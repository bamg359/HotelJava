package application.service;

import application.domain.Employee;

import java.util.Optional;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee updateEmployee (Employee employee);

    Optional<Employee> getEmployeeById(int id);

}
