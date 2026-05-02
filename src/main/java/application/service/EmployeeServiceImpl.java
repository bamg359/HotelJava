package application.service;

import application.domain.Employee;
import application.service.outputs.EmployeeService;
import application.service.ports.EmployeeRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepositoryPort employeeRepository;
    public EmployeeServiceImpl(EmployeeRepositoryPort employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee createEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> existing = getEmployeeById(employee.getId());
        if (existing.isPresent()) {
            employees.remove(existing.get());
            employees.add(employee);
            return employee;
        }
        return null;
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }
}
