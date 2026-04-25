package application.repository;

import application.domain.Guest;
import application.service.ports.GuestRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GuestRepository implements GuestRepositoryPort {
    private final List<Guest> guests = new ArrayList<>();

    @Override
    public Guest save(Guest guest) {
        guests.add(guest);
        return guest;
    }

    @Override
    public Guest update(Guest guest) {
        deleteById(guest.getId());
        guests.add(guest);
        return guest;
    }

    @Override
    public Optional<Guest> findById(int id) {
        return guests.stream()
                .filter(g -> g.getId() == id)
                .findFirst();
    }

    @Override
    public List<Guest> findAll() {
        return new ArrayList<>(guests);
    }

    @Override
    public boolean deleteById(int id) {
        return guests.removeIf(g -> g.getId() == id);
    }
}
