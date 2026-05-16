package hotel.userinterface;

import hotel.infraestructure.in.view.adapter.BedRoomTypeView;
import hotel.infraestructure.out.db.DataBaseConnectionMySQL;
import hotel.infraestructure.util.FormValidationUtil;
import hotel.infraestructure.in.view.adapter.BedRoomView;
import hotel.infraestructure.in.view.adapter.GuestView;

import java.util.Scanner;

public class MenuApp {

    Scanner sc = new Scanner(System.in);

    private final GuestView guestView;
    private final BedRoomView bedRoomView;
    private final BedRoomTypeView bedRoomTypeView;

    public MenuApp(GuestView guestView, BedRoomView bedRoomView, BedRoomTypeView bedRoomTypeView) {
        this.guestView = guestView;
        this.bedRoomView = bedRoomView;
        this.bedRoomTypeView = bedRoomTypeView;
    }

    public void showMainMenu(){

        System.out.println("Bienvenido al Hotel Java");

        int init = FormValidationUtil.validateInt("Presione 1 para iniciar la aplicacion");
        sc.nextLine();
        while(init != 0){
            DataBaseConnectionMySQL.getInstance().getConnection();
            System.out.println("Seleccione 1. Registrar Usuario 2. Iniciar Sesion 3. Salir");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    System.out.println("Registrar Usuario");
                    guestView.createGuest();
                    break;
                case 2:
                    System.out.println("Iniciar Sesion");
                    //showGuestMenu();
                    showBedRoomMenu();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicacion");
                    init = 0;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }

        }
    }


    public void showGuestMenu(){

        System.out.println("Menu Huespedes");

        Boolean init = true;

        while(init){

            System.out.println("Seleccione 1. Crear Huesped 2. Actualizar Huesped 3. Eliminar Huesped 4. Listar Huespedes 5. Buscar huesped por id 6. salir");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    System.out.println("Crear huesped");
                    guestView.createGuest();
                    break;
                case 2:
                    System.out.println("Actualizar Huesped");
                    break;
                case 3:
                    System.out.println("Eliminar Huesped");
                    break;
                case 4:
                    System.out.println("Listar Huespedes");
                        guestView.getAllGuests();
                    break;
                case 5:
                    System.out.println("Buscar huesped por id");
                    break;
                case 6:
                    System.out.println("Saliendo del menu de huespedes");
                    init = false;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");

            }
        }
    }


    public void showBedRoomMenu(){

        System.out.println("Menu Habitaciones");

        Boolean init = true;

        while(init){

            System.out.println("Seleccione 1. Crear Habitaciones \n" +
                    "3. Eliminar Habitaciones 4. Listar Hueabitaciones \n " +
                    "5. Buscar habitaciones por id 6. Crear Tipo de Habitacion \n" +
                    "7. Listar Tipo de Habitacion 8.Buscar Tipo x Id 9. Eliminar tipo por id 10. Salir");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    System.out.println("Crear huesped");
                    bedRoomView.createBedRoom();
                    break;
                case 2:
                    System.out.println("Actualizar Habitaciones");
                    bedRoomView.updateBedRoom();
                    break;
                case 3:
                    System.out.println("Eliminar Habitaciones");
                    bedRoomView.deleteBedRoomById();
                    break;
                case 4:
                    System.out.println("Listar Habitaciones");
                    bedRoomView.getAllBedRooms();
                    break;
                case 5:
                    System.out.println("Buscar habitaciones por id");
                    bedRoomView.getBedRoomById();
                    break;
                case 6:
                    System.out.println("Crear Tipo de Habitacion");
                    bedRoomTypeView.createBedRoomTypeView();
                    break;
                case 7:
                    System.out.println("Listar Tipo de Habitacion");
                    bedRoomTypeView.getAllBedRoomTypesView();
                    break;
                case 8:
                    System.out.println("Buscar Tipo de Hab por Id");
                    bedRoomTypeView.getBedRoomTypeById();
                    break;
                case 9:
                    System.out.println("Eliminar Tipo");
                    bedRoomTypeView.deleteBedRoomType();
                    break;
                case 10:
                    System.out.println("Saliendo del menu de habitaciones");
                    init = false;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");

            }
        }
    }




}
