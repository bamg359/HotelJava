package application.repository;

import application.domain.Guest;
import application.service.ports.GuestAdminRepositoryPort;

import java.util.ArrayList;
import java.util.List;

public class GuestAdminRepository implements GuestAdminRepositoryPort {

    private final List<Guest> guests = new ArrayList<>();

    @Override
    public List<Guest> getAllGuests() {
        return guests;
    }

    @Override
    public boolean deleteById(int id) {
        return guests.removeIf(g -> g.getId() == id); // ✅ elimina por ID
    }
}
