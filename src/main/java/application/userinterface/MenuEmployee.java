package application.userinterface;

import application.view.EmployeeView;
import application.util.FormValidationUtil;

public class MenuEmployee {

    private final EmployeeView employeeView;

    public MenuEmployee(EmployeeView employeeView) {
        this.employeeView = employeeView;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n=== MENÚ EMPLEADOS ===");
            System.out.println("1. Crear empleado");
            System.out.println("2. Actualizar empleado");
            System.out.println("3. Consultar empleado por ID");
            System.out.println("4. Listar todos los empleados");
            System.out.println("5. Eliminar empleado");
            System.out.println("0. Volver al menú principal");
            option = FormValidationUtil.validateInt("Seleccione una opción:");

            switch (option) {
                case 1 -> employeeView.createEmployee();
                case 2 -> employeeView.updateEmployee();
                case 3 -> employeeView.consultEmployeeById();
                case 4 -> employeeView.listAllEmployees();
                case 5 -> employeeView.deleteEmployee();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (option != 0);
    }
}
