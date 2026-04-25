package application.service.ports;

import application.domain.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepositoryPort {
    Employee save(Employee employee);
    Employee update(Employee employee);
    Optional<Employee> findById(int id);
    List<Employee> findAll();
    boolean deleteById(int id);
}
