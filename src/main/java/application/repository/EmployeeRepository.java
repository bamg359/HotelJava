package application.repository;

import application.domain.Employee;
import application.service.ports.EmployeeRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository implements EmployeeRepositoryPort {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        deleteById(employee.getId());
        employees.add(employee);
        return employee;
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    @Override
    public boolean deleteById(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }
}
