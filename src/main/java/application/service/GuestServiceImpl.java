package application.service;

import application.domain.Guest;
import application.service.outputs.GuestService;
import application.service.ports.GuestRepositoryPort;
import application.util.FormValidationUtil;

import java.util.List;
import java.util.Optional;

public class GuestServiceImpl implements GuestService {

    private final GuestRepositoryPort guestRepository;

    public GuestServiceImpl(GuestRepositoryPort guestRepository){
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest createGuest(Guest guest) {
        guest.setId(FormValidationUtil.validateInt("Ingrese el id del huésped"));
        guest.setName(FormValidationUtil.validateString("Ingrese el nombre del huésped"));
        guest.setLastName(FormValidationUtil.validateString("Ingrese el apellido"));
        guest.setEmail(FormValidationUtil.validateString("Ingrese el email"));
        guest.setPassword(FormValidationUtil.validateString("Ingrese el password"));
        guest.setState(FormValidationUtil.validateBoolean("Estado huésped (true/false)"));
        guest.setOrigin(FormValidationUtil.validateString("Ingrese el origen"));
        guest.setGuestType(FormValidationUtil.validateString("Ingrese el tipo de huésped"));

        return guestRepository.save(guest);
    }

    @Override
    public Guest updateGuest(Guest guest) {
        return guestRepository.update(guest);
    }

    @Override
    public Optional<Guest> getGuestById(int id) {
        return Optional.ofNullable(guestRepository.findById(id));
    }

    public List<Guest> listGuests() {
        return guestRepository.findAll();
    }

    public void deleteGuest(int id) {
        guestRepository.deleteById(id);
    }
}
