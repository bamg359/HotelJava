package application.service;

import application.domain.Guest;
import application.repository.GuestRepository;
import application.service.outputs.GuestService;

import java.util.List;
import java.util.Optional;

public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Guest updateGuest(int id, Guest guest) {
        return guestRepository.update(id, guest);
    }

    @Override
    public Optional<Guest> getGuestById(int id) {
        return Optional.ofNullable(guestRepository.findById(id));
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();   // <-- implementación correcta
    }

    @Override
    public void deleteGuest(int id) {
        guestRepository.deleteById(id);
    }
}
