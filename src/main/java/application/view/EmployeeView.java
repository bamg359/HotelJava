package application.view;

import application.domain.Employee;
import application.service.outputs.EmployeeService;
import application.util.FormValidationUtil;

import java.util.List;
import java.util.Optional;

public class EmployeeView {

    private final EmployeeService employeeService;

    public EmployeeView(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- MENÚ DE EMPLEADOS ---");
            System.out.println("1. Crear empleado");
            System.out.println("2. Actualizar empleado");
            System.out.println("3. Consultar empleado por ID");
            System.out.println("4. Listar todos los empleados");
            System.out.println("5. Eliminar empleado");
            System.out.println("0. Salir");
            option = FormValidationUtil.validateInt("Seleccione una opción:");

            switch (option) {
                case 1 -> createEmployee();
                case 2 -> updateEmployee();
                case 3 -> getEmployeeById();
                case 4 -> listAllEmployees();
                case 5 -> deleteEmployee();
                case 0 -> System.out.println("Saliendo del menú de empleados...");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (option != 0);
    }

    private void createEmployee() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del empleado");
        String firstName = FormValidationUtil.validateString("Ingrese el nombre");
        String lastName = FormValidationUtil.validateString("Ingrese el apellido");

        System.out.println("--- ESTADO DEL EMPLEADO ---");
        System.out.println("1. ACTIVO");
        System.out.println("2. INACTIVO");
        int stateOption = FormValidationUtil.validateInt("Ingrese el número del estado");
        boolean state = (stateOption == 1);

        Employee employee = new Employee(id, firstName, lastName);
        employee.setActive(state);

        employeeService.createEmployee(employee);
        System.out.println("Empleado creado correctamente.");
    }


    private void updateEmployee() {
        Employee employee = new Employee();
        employeeService.updateEmployee(employee);
        System.out.println("Empleado actualizado correctamente.");
    }

    private void getEmployeeById() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del empleado a consultar");
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        employee.ifPresentOrElse(
                e -> System.out.println("Empleado encontrado: " + e.getId() + " " + e.getName() + " " + e.getPosition() + " $" + e.getSalary()),
                () -> System.out.println("No se encontró el empleado con ID " + id)
        );
    }

    private void listAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println("--- LISTA DE EMPLEADOS ---");
        employees.forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getPosition() + " $" + e.getSalary()));
    }

    private void deleteEmployee() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del empleado a eliminar");
        employeeService.deleteEmployee(id);
        System.out.println("Empleado eliminado correctamente.");
    }
}
