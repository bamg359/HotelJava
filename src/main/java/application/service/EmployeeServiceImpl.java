package application.service;

import application.domain.Employee;
import application.service.outputs.EmployeeService;
import application.service.ports.EmployeeRepositoryPort;
import application.util.FormValidationUtil;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryPort employeeRepository;

    public EmployeeServiceImpl(EmployeeRepositoryPort employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(FormValidationUtil.validateInt("Ingrese el ID del empleado"));
        employee.setName(FormValidationUtil.validateString("Ingrese el nombre"));
        employee.setLastName(FormValidationUtil.validateString("Ingrese el apellido"));
        employee.setEmail(FormValidationUtil.validateString("Ingrese el email"));
        employee.setPassword(FormValidationUtil.validateString("Ingrese la contraseña"));
        employee.setState(FormValidationUtil.validateBoolean("Estado del empleado (true/false)"));
        employee.setPosition(FormValidationUtil.validateString("Ingrese el cargo"));
        employee.setSalary(FormValidationUtil.validateDouble("Ingrese el salario"));

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employee.setId(FormValidationUtil.validateInt("Ingrese el ID del empleado a actualizar"));
        employee.setName(FormValidationUtil.validateString("Ingrese el nombre actualizado"));
        employee.setLastName(FormValidationUtil.validateString("Ingrese el apellido actualizado"));
        employee.setEmail(FormValidationUtil.validateString("Ingrese el email actualizado"));
        employee.setPassword(FormValidationUtil.validateString("Ingrese la contraseña actualizada"));
        employee.setState(FormValidationUtil.validateBoolean("Estado del empleado (true/false)"));
        employee.setPosition(FormValidationUtil.validateString("Ingrese el cargo actualizado"));
        employee.setSalary(FormValidationUtil.validateDouble("Ingrese el salario actualizado"));

        return employeeRepository.update(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return Optional.ofNullable(employeeRepository.findById(id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}