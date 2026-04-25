package application.view;

import application.domain.Guest;
import application.domain.enums.GuestState;
import application.domain.enums.GuestType;
import application.service.outputs.GuestAdminService;
import application.service.outputs.GuestService;
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
                case 4 -> listAllGuests();
                case 5 -> deleteGuest();
                case 0 -> System.out.println("Saliendo del menú de huéspedes...");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (option != 0);
    }

    private void createGuest() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped");
        String firstName = FormValidationUtil.validateString("Ingrese el nombre");
        String lastName = FormValidationUtil.validateString("Ingrese el apellido");
        String email = FormValidationUtil.validateString("Ingrese el correo");
        String phone = FormValidationUtil.validateString("Ingrese el teléfono");

        System.out.println("--- ESTADO DE HUÉSPED ---");
        System.out.println("1. ACTIVO");
        System.out.println("2. DESCONECTADO");
        int stateOption = FormValidationUtil.validateInt("Ingrese el número del estado");
        GuestState state = GuestState.fromOption(stateOption);

        String city = FormValidationUtil.validateString("Ingrese la ciudad");

        System.out.println("--- TIPOS DE HUÉSPED ---");
        System.out.println("1. Nuevo");
        System.out.println("2. Frecuente");
        System.out.println("3. VIP");
        int typeOption = FormValidationUtil.validateInt("Ingrese el número del tipo");
        GuestType type = GuestType.fromOption(typeOption);

        Guest guest = new Guest(id, firstName, lastName, email, phone,
                state == GuestState.ACTIVE, city, type.getDescription());
        guestService.createGuest(guest);
        System.out.println("Huésped creado correctamente.");
    }

    private void updateGuest() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped a actualizar");
        String firstName = FormValidationUtil.validateString("Ingrese el nombre actualizado");
        String lastName = FormValidationUtil.validateString("Ingrese el apellido actualizado");
        String email = FormValidationUtil.validateString("Ingrese el correo actualizado");
        String phone = FormValidationUtil.validateString("Ingrese el teléfono actualizado");

        System.out.println("--- ESTADO DE HUÉSPED ---");
        System.out.println("1. ACTIVO");
        System.out.println("2. DESCONECTADO");
        int stateOption = FormValidationUtil.validateInt("Ingrese el número del estado");
        GuestState state = GuestState.fromOption(stateOption);

        String city = FormValidationUtil.validateString("Ingrese la ciudad actualizada");

        System.out.println("--- TIPOS DE HUÉSPED ---");
        System.out.println("1. Nuevo");
        System.out.println("2. Frecuente");
        System.out.println("3. VIP");
        int typeOption = FormValidationUtil.validateInt("Ingrese el número del tipo");
        GuestType type = GuestType.fromOption(typeOption);

        Guest guest = new Guest(id, firstName, lastName, email, phone,
                state == GuestState.ACTIVE, city, type.getDescription());
        guestService.updateGuest(id, guest);
        System.out.println("Huésped actualizado correctamente.");
    }

    private void getGuestById() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped a consultar");
        Optional<Guest> guest = guestService.getGuestById(id);
        guest.ifPresentOrElse(
                g -> {
                    String stateText = g.isActive() ? GuestState.ACTIVE.getDescription() : GuestState.INACTIVE.getDescription();
                    System.out.println("Huésped encontrado: " + g.getId() + " " +
                            g.getFirstName() + " " + g.getLastName() + " Email: " + g.getEmail() +
                            " Teléfono: " + g.getPhone() + " Estado: " + stateText +
                            " Ciudad: " + g.getCity() + " Tipo: " + g.getType());
                },
                () -> System.out.println("No se encontró el huésped con ID " + id)
        );
    }

    private void listAllGuests() {
        List<Guest> guests = guestService.getAllGuests();
        System.out.println("--- LISTA DE HUÉSPEDES ---");
        guests.forEach(g -> {
            String stateText = g.isActive() ? GuestState.ACTIVE.getDescription() : GuestState.INACTIVE.getDescription();
            System.out.println(g.getId() + " " + g.getFirstName() + " " + g.getLastName() +
                    " Email: " + g.getEmail() + " Teléfono: " + g.getPhone() +
                    " Estado: " + stateText + " Ciudad: " + g.getCity() +
                    " Tipo: " + g.getType());
        });
    }

    private void deleteGuest() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped a eliminar");
        guestService.deleteGuest(id);
        System.out.println("Huésped eliminado correctamente.");
    }
}
