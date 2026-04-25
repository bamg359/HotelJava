package application.view;

import application.domain.Guest;
import application.domain.enums.GuestType;
import application.domain.enums.PersonState;
import application.service.outputs.GuestAdminService;
import application.service.outputs.GuestService;
import application.util.FormValidationUtil;

import java.util.List;

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
            System.out.println("--- MENÚ DE HUÉSPEDES ---");
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
                case 3 -> consultGuestById();
                case 4 -> listAllGuests();
                case 5 -> deleteGuest();
                case 0 -> System.out.println("Saliendo del menú de huéspedes...");
                default -> System.out.println("Opción inválida.");
            }
        } while (option != 0);
    }

    private void createGuest() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped");
        String firstName = FormValidationUtil.validateString("Ingrese el nombre");
        String lastName = FormValidationUtil.validateString("Ingrese el apellido");
        String email = FormValidationUtil.validateString("Ingrese el email");
        String phone = FormValidationUtil.validateString("Ingrese el teléfono");

        System.out.println("--- ESTADO DEL HUÉSPED ---");
        System.out.println("1. ACTIVO");
        System.out.println("2. INACTIVO");
        int stateOption = FormValidationUtil.validateInt("Ingrese el número del estado");
        PersonState state = PersonState.fromOption(stateOption);

        System.out.println("--- TIPO DE HUÉSPED ---");
        System.out.println("1. NUEVO");
        System.out.println("2. FRECUENTE");
        int typeOption = FormValidationUtil.validateInt("Ingrese el número del tipo");
        GuestType type = GuestType.fromOption(typeOption);

        String city = FormValidationUtil.validateString("Ingrese la ciudad");

        Guest guest = new Guest(id, firstName, lastName, email, phone, state, type, city);
        guestService.createGuest(guest);
        System.out.println("Huésped creado correctamente.");
    }

    private void updateGuest() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped a actualizar");
        Guest guest = guestService.getGuestById(id).orElse(null);

        if (guest == null) {
            System.out.println("Huésped no encontrado.");
            return;
        }

        guest.setFirstName(FormValidationUtil.validateString("Ingrese el nuevo nombre"));
        guest.setLastName(FormValidationUtil.validateString("Ingrese el nuevo apellido"));
        guest.setEmail(FormValidationUtil.validateString("Ingrese el nuevo email"));
        guest.setPhone(FormValidationUtil.validateString("Ingrese el nuevo teléfono"));

        System.out.println("--- ESTADO DEL HUÉSPED ---");
        System.out.println("1. ACTIVO");
        System.out.println("2. INACTIVO");
        int stateOption = FormValidationUtil.validateInt("Ingrese el número del estado");
        guest.setState(PersonState.fromOption(stateOption));

        System.out.println("--- TIPO DE HUÉSPED ---");
        System.out.println("1. NUEVO");
        System.out.println("2. FRECUENTE");
        int typeOption = FormValidationUtil.validateInt("Ingrese el número del tipo");
        guest.setType(GuestType.fromOption(typeOption));

        guest.setCity(FormValidationUtil.validateString("Ingrese la ciudad actualizada"));

        guestService.updateGuest(id, guest);
        System.out.println("Huésped actualizado correctamente.");
    }

    private void consultGuestById() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped");
        Guest guest = guestService.getGuestById(id).orElse(null);

        if (guest == null) {
            System.out.println("Huésped no encontrado.");
            return;
        }

        System.out.println("--- HUÉSPED ---");
        System.out.println("ID: " + guest.getId());
        System.out.println("Nombre: " + guest.getFullName());
        System.out.println("Email: " + guest.getEmail());
        System.out.println("Teléfono: " + guest.getPhone());
        System.out.println("Estado: " + guest.getStateText());
        System.out.println("Tipo: " + guest.getType().getDescription());
        System.out.println("Ciudad: " + guest.getCity());
    }

    private void listAllGuests() {
        List<Guest> guests = guestService.getAllGuests();
        System.out.println("--- LISTA DE HUÉSPEDES ---");
        guests.forEach(g -> System.out.println(
                g.getId() + " " + g.getFullName() +
                        " Email: " + g.getEmail() +
                        " Teléfono: " + g.getPhone() +
                        " Estado: " + g.getStateText() +
                        " Tipo: " + g.getType().getDescription() +
                        " Ciudad: " + g.getCity()
        ));
    }

    private void deleteGuest() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped a eliminar");
        boolean deleted = guestService.deleteGuest(id);

        if (deleted) {
            System.out.println("Huésped eliminado correctamente.");
        } else {
            System.out.println("Huésped no encontrado.");
        }
    }
}
