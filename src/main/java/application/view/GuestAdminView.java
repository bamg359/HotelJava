package application.view;

import application.service.outputs.GuestAdminService;
import application.util.FormValidationUtil;

public class GuestAdminView {
    private final GuestAdminService guestAdminService;

    public GuestAdminView(GuestAdminService guestAdminService) {
        this.guestAdminService = guestAdminService;
    }

    public void listGuests() {
        System.out.println("--- LISTA DE HUÉSPEDES ---");
        guestAdminService.getGuests().forEach(g ->
                System.out.println(g.getId() + " - " + g.getFullName() + " (" + g.getStateText() + ")")
        );
    }

    public void deleteGuest() {
        int id = FormValidationUtil.validateInt("Ingrese el ID del huésped a eliminar");
        guestAdminService.deleteGuest(id);
        System.out.println("Huésped con ID " + id + " eliminado correctamente.");
    }
}
