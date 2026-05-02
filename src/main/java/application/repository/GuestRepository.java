package application.repository;

import application.domain.Guest;
import application.service.ports.GuestRepositoryPort;
import application.service.ports.GuestAdminRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GuestRepository implements GuestRepositoryPort, GuestAdminRepositoryPort {

    private final List<Guest> guests = new ArrayList<>();

    @Override
    public List<Guest> getAllGuests() {
        return guests;
    }

    @Override
    public boolean deleteById(int id) {
        return guests.removeIf(g -> g.getId() == id); // ✅ devuelve true si eliminó
    }

    // Métodos de GuestRepositoryPort
    @Override
    public Optional<Guest> findById(int id) {
        return guests.stream().filter(g -> g.getId() == id).findFirst();
    }

    @Override
    public Guest save(Guest guest) {
        guests.add(guest);
        return guest;
    }

    @Override
    public Guest update(Guest guest) {
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getId() == guest.getId()) {
                guests.set(i, guest);
                return guest;
            }
        }
        return null;
    }

    @Override
    public List<Guest> findAll() {
        return guests;
    }
}
