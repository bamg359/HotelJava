package application.view;

import application.domain.Guest;
import application.service.outputs.GuestService;
import application.service.outputs.GuestAdminService;
import application.util.FormValidationUtil;

import java.util.List;
import java.util.Optional;

public class GuestView {

    private final GuestService guestService;
    private final GuestAdminService guestAdminService;

    public GuestView(GuestService guestService, GuestAdminService guestAdminService) {
        this.guestService = guestService;
        this.guestAdminService = guestAdminService;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- MENÚ DE HUÉSPEDES ---");
            System.out.println("1. Crear huésped");
            System.out.println("2. Actualizar huésped");
            System.out.println("3. Consultar huésped por ID");
            System.out.println("4. Listar todos los huéspedes");
            System.out.println("5. Eliminar huésped");
            System.out.println("0. Salir");
            option = FormValidationUtil.validateInt("Seleccione una opción:");

            switch (option) {
                case 1 -> createGuest();
                case 2 -> updateGuest();
                case 3 -> getGuestById();
                case 4 -> getAllGuests();
                case 5 -> deleteGuest();
                case 0 -> System.out.println("Saliendo del menú de huéspedes...");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (option != 0);
    }

    private void createGuest() {
        Guest guest = new Guest();
        guestService.createGuest(guest);
        System.out.println("Huésped creado correctamente.");
    }

    private void updateGuest() {
        Guest guest = new Guest();
        guestService.updateGuest(guest);
        System.out.println("Huésped actualizado correctamente.");
    }

    private void getGuestById() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped a consultar");
        Optional<Guest> guest = guestService.getGuestById(id);
        guest.ifPresentOrElse(
                g -> System.out.println("Huésped encontrado: " + g.getId() + " " + g.getName() + " " + g.getLastName()),
                () -> System.out.println("No se encontró el huésped con ID " + id)
        );
    }

    private void getAllGuests() {
        List<Guest> guests = guestAdminService.getGuests();
        System.out.println("--- LISTA DE HUÉSPEDES ---");
        guests.forEach(g -> System.out.println(g.getId() + " " + g.getName() + " " + g.getLastName() + " " + g.getEmail()));
    }

    private void deleteGuest() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped a eliminar");
        guestAdminService.deleteGuest(id);
        System.out.println("Huésped eliminado correctamente.");
    }
}
