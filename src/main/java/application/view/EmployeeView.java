package application.view;

import application.domain.Employee;
import application.domain.enums.PersonState;
import application.service.outputs.EmployeeService;
import application.util.FormValidationUtil;

import java.util.List;

public class EmployeeView {
    private final EmployeeService employeeService;

    public EmployeeView(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("--- MENÚ DE EMPLEADOS ---");
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
                case 3 -> consultEmployeeById();
                case 4 -> listAllEmployees();
                case 5 -> deleteEmployee();
                case 0 -> System.out.println("Saliendo del menú de empleados...");
                default -> System.out.println("Opción inválida.");
            }
        } while (option != 0);
    }
    private void createEmployee() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del empleado");
        String firstName = FormValidationUtil.validateString("Ingrese el nombre");
        String lastName = FormValidationUtil.validateString("Ingrese el apellido");
        String email = FormValidationUtil.validateString("Ingrese el email");
        String phone = FormValidationUtil.validateString("Ingrese el teléfono");

        System.out.println("--- ESTADO DEL EMPLEADO ---");
        System.out.println("1. ACTIVO");
        System.out.println("2. INACTIVO");
        int stateOption = FormValidationUtil.validateInt("Ingrese el número del estado");
        PersonState state = PersonState.fromOption(stateOption);

        String position = FormValidationUtil.validateString("Ingrese el cargo");
        double salary = FormValidationUtil.validateDouble("Ingrese el salario");

        Employee employee = new Employee(id, firstName, lastName, email, phone, state, position, salary);
        employeeService.createEmployee(employee); // ✅ el servicio solo guarda
        System.out.println("Empleado creado correctamente.");
    }



    private void updateEmployee() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del empleado a actualizar");
        Employee employee = employeeService.getEmployeeById(id).orElse(null);

        if (employee == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }

        employee.setFirstName(FormValidationUtil.validateString("Ingrese el nuevo nombre"));
        employee.setLastName(FormValidationUtil.validateString("Ingrese el nuevo apellido"));
        employee.setEmail(FormValidationUtil.validateString("Ingrese el nuevo email"));
        employee.setPhone(FormValidationUtil.validateString("Ingrese el nuevo teléfono"));

        System.out.println("--- ESTADO DEL EMPLEADO ---");
        System.out.println("1. ACTIVO");
        System.out.println("2. INACTIVO");
        int stateOption = FormValidationUtil.validateInt("Ingrese el número del estado");
        employee.setState(PersonState.fromOption(stateOption));

        employee.setPosition(FormValidationUtil.validateString("Ingrese el nuevo cargo"));
        employee.setSalary(FormValidationUtil.validateDouble("Ingrese el nuevo salario"));

        employeeService.updateEmployee(employee);
        System.out.println("Empleado actualizado correctamente.");
    }

    private void consultEmployeeById() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del empleado");
        Employee employee = employeeService.getEmployeeById(id).orElse(null);

        if (employee == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }

        System.out.println("--- EMPLEADO ---");
        System.out.println("ID: " + employee.getId());
        System.out.println("Nombre: " + employee.getFullName());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Teléfono: " + employee.getPhone());
        System.out.println("Estado: " + employee.getStateText());
        System.out.println("Cargo: " + employee.getPosition());
        System.out.println("Salario: " + employee.getSalary());
    }

    private void listAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println("--- LISTA DE EMPLEADOS ---");
        employees.forEach(e -> System.out.println(
                e.getId() + " " + e.getFullName() +
                        " Email: " + e.getEmail() +
                        " Teléfono: " + e.getPhone() +
                        " Estado: " + e.getStateText() +
                        " Cargo: " + e.getPosition() +
                        " Salario: " + e.getSalary()
        ));
    }

    private void deleteEmployee() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del empleado a eliminar");
        boolean deleted = employeeService.deleteEmployee(id);

        if (deleted) {
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }
}
