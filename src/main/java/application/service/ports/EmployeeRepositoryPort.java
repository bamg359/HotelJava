package application.service.ports;

import application.domain.Employee;

import java.util.List;

public interface EmployeeRepositoryPort {

    Employee save(Employee employee);
    Employee update(Employee employee);
    Employee findById(int id);
    List<Employee> findAll();
    void deleteById(int id);

}
