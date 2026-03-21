package application.service;

import application.domain.Employee;
import application.view.EmployeeView;

import java.util.List;

public interface EmployeeAdminService {

    public void deleteEmployee(int id);

    public List<Employee> getAllEmployee(List<EmployeeView> employeeList);

}
