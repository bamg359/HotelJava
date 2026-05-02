package application.service;

import application.domain.Guest;
import application.service.outputs.GuestAdminService;
import application.service.ports.GuestAdminRepositoryPort;

import java.util.List;

public class GuestAdminServiceImpl implements GuestAdminService {

    private final GuestAdminRepositoryPort guestAdminRepository;

    public GuestAdminServiceImpl(GuestAdminRepositoryPort guestAdminRepository) {
        this.guestAdminRepository = guestAdminRepository;
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestAdminRepository.getAllGuests();
    }

    @Override
    public boolean deleteGuest(int id) {
        return guestAdminRepository.deleteById(id);
    }
}
