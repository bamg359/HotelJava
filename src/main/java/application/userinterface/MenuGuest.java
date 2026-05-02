package application.userinterface;

import application.view.GuestView;
import application.util.FormValidationUtil;

public class MenuGuest {

    private final GuestView guestView;

    public MenuGuest(GuestView guestView) {
        this.guestView = guestView;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n=== MENÚ HUÉSPEDES ===");
            System.out.println("1. Crear huésped");
            System.out.println("2. Actualizar huésped");
            System.out.println("3. Consultar huésped por ID");
            System.out.println("4. Listar todos los huéspedes");
            System.out.println("5. Eliminar huésped");
            System.out.println("0. Volver al menú principal");
            option = FormValidationUtil.validateInt("Seleccione una opción:");

            switch (option) {
                case 1 -> guestView.createGuest();
                case 2 -> guestView.updateGuest();
                case 3 -> guestView.consultGuestById();
                case 4 -> guestView.listAllGuests();
                case 5 -> guestView.deleteGuest();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (option != 0);
    }
}
