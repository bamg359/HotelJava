package application.userinterface;

import application.util.FormValidationUtil;
import application.view.BedRoomView;
import application.view.GuestView;
import application.view.EmployeeView;

public class MenuApp {

    private final GuestView guestView;
    private final BedRoomView bedRoomView;
    private final EmployeeView employeeView;

    public MenuApp(GuestView guestView, BedRoomView bedRoomView, EmployeeView employeeView){
        this.guestView = guestView;
        this.bedRoomView = bedRoomView;
        this.employeeView = employeeView;
    }

    public void showMainMenu(){
        int option;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Gestión de huéspedes");
            System.out.println("2. Gestión de habitaciones");
            System.out.println("3. Gestión de empleados");
            System.out.println("0. Salir");
            option = FormValidationUtil.validateInt("Seleccione una opción:");

            switch (option){
                case 1 -> guestView.showMenu();
                case 2 -> bedRoomView.showMenu();
                case 3 -> employeeView.showMenu();
                case 0 -> System.out.println("Saliendo de la aplicación...");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        } while(option != 0);
    }
}