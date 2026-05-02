package application.view;

import application.domain.Guest;
import application.service.outputs.GuestService;
import application.service.outputs.GuestAdminService;
import application.util.FormValidationUtil;

import java.util.List;

public class GuestView {
    private final GuestService guestService;
    private final GuestAdminService guestAdminService;

    // Constructor con ambos servicios
    public GuestView(GuestService guestService, GuestAdminService guestAdminService) {
        this.guestService = guestService;
        this.guestAdminService = guestAdminService;
    }

    public void createGuest() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped");
        String firstName = FormValidationUtil.validateString("Ingrese el nombre");
        String lastName = FormValidationUtil.validateString("Ingrese el apellido");
        String email = FormValidationUtil.validateString("Ingrese el email");
        String phone = FormValidationUtil.validateString("Ingrese el teléfono");
        boolean state = FormValidationUtil.validateBoolean("¿Está activo? (true/false)");
        String city = FormValidationUtil.validateString("Ingrese la ciudad");

        Guest guest = new Guest(id, firstName, lastName, email, phone, state, city);
        guestService.createGuest(guest);
        System.out.println("✅ Huésped creado correctamente.");
    }

    public void updateGuest() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped a actualizar");
        Guest guest = guestService.getGuestById(id).orElse(null);

        if (guest == null) {
            System.out.println("❌ Huésped no encontrado.");
            return;
        }

        guest.setFirstName(FormValidationUtil.validateString("Ingrese el nuevo nombre"));
        guest.setLastName(FormValidationUtil.validateString("Ingrese el nuevo apellido"));
        guest.setEmail(FormValidationUtil.validateString("Ingrese el nuevo email"));
        guest.setPhone(FormValidationUtil.validateString("Ingrese el nuevo teléfono"));
        guest.setState(FormValidationUtil.validateBoolean("¿Está activo? (true/false)"));
        guest.setCity(FormValidationUtil.validateString("Ingrese la nueva ciudad"));

        guestService.updateGuest(id, guest);
        System.out.println("✅ Huésped actualizado correctamente.");
    }

    public void consultGuestById() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped");
        Guest guest = guestService.getGuestById(id).orElse(null);

        if (guest == null) {
            System.out.println("❌ Huésped no encontrado.");
            return;
        }

        System.out.println("--- HUÉSPED ---");
        System.out.println("ID: " + guest.getId());
        System.out.println("Nombre: " + guest.getFullName());
        System.out.println("Email: " + guest.getEmail());
        System.out.println("Teléfono: " + guest.getPhone());
        System.out.println("Estado: " + (guest.getState() ? "Activo" : "Inactivo"));
        System.out.println("Ciudad: " + guest.getCity());
    }

    public void listAllGuests() {
        List<Guest> guests = guestService.getAllGuests();
        if (guests.isEmpty()) {
            System.out.println("No hay huéspedes registrados.");
        } else {
            System.out.println("--- LISTA DE HUÉSPEDES ---");
            guests.forEach(g -> System.out.println(
                    g.getId() + " " + g.getFullName() +
                            " Email: " + g.getEmail() +
                            " Teléfono: " + g.getPhone() +
                            " Estado: " + (g.getState() ? "Activo" : "Inactivo") +
                            " Ciudad: " + g.getCity()
            ));
        }
    }

    public void deleteGuest() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped a eliminar");
        boolean deleted = guestAdminService.deleteGuest(id);

        if (deleted) {
            System.out.println("✅ Huésped eliminado correctamente.");
        } else {
            System.out.println("❌ Huésped no encontrado.");
        }
    }

}
