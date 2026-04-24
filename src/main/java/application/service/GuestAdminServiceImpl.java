package application.service;

import application.domain.Guest;
import application.repository.GuestRepository;
import application.service.outputs.GuestAdminService;
import application.util.FormValidationUtil;

import java.util.List;

public class GuestAdminServiceImpl implements GuestAdminService {

    private final GuestRepository guestRepository;

    public GuestAdminServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public List<Guest> getGuests() {
        return guestRepository.findAll(); // usamos el método estándar del repositorio
    }

    @Override
    public void deleteGuest(int id) {
        // Validamos la entrada antes de eliminar
        int guestId = FormValidationUtil.validateInt("Ingrese el ID del huésped a eliminar");
        guestRepository.deleteById(guestId);
        System.out.println("Huésped con ID " + guestId + " eliminado correctamente.");
    }
}
