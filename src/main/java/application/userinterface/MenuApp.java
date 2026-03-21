package application.userinterface;

import application.view.EmployeeView;
import application.view.GuestView;

import java.util.Scanner;

public class MenuApp {

    Scanner sc = new Scanner(System.in);

    private final GuestView guestView;

    private final EmployeeView employeeView;

    public MenuApp(GuestView guestView, EmployeeView employeeView) {
        this.guestView = guestView;
        this.employeeView = employeeView;
    }

    public void showMainMenu() {
        System.out.println("===========================");
        System.out.println("         HOTEL JAVA        ");
        System.out.println("===========================");
        System.out.println("Presione [1] para iniciar la app");
        int init = sc.nextInt();

        while(init != 0){
            System.out.println("1. Registrar usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("Registrar usuario");
                    guestView.createGuest();
                    break;
                case 2:
                    employeeView.createEmployee();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicacion...");
                    init = 0;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }

    }

}
