package application.service;

import application.domain.Guest;
import application.service.outputs.GuestService;
import application.service.ports.GuestRepositoryPort;

import java.util.List;
import java.util.Optional;

public class GuestServiceImpl implements GuestService {

    private final GuestRepositoryPort guestRepository;


    public GuestServiceImpl(GuestRepositoryPort guestRepository) { // ✅ interfaz
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Guest updateGuest(int id, Guest guest) {
        Optional<Guest> existing = guestRepository.findById(id);
        if (existing.isPresent()) {
            return guestRepository.update(guest);
        }
        return null;
    }

    @Override
    public Optional<Guest> getGuestById(int id) {
        return guestRepository.findById(id);
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public boolean deleteGuest(int id) {
        return guestRepository.deleteById(id);
    }
}
