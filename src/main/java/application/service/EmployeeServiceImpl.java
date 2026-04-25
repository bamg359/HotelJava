package application.service;

import application.domain.Employee;
import application.service.outputs.EmployeeService;
import application.service.ports.EmployeeRepositoryPort;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepositoryPort employeeRepository;

    public EmployeeServiceImpl(EmployeeRepositoryPort employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }


    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteById(id);
    }
}
