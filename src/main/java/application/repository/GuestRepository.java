package application.repository;

import application.domain.Guest;
import application.service.ports.GuestRepositoryPort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuestRepository implements GuestRepositoryPort {

    private final List<Guest> guests = new ArrayList<>(
            Arrays.asList(
                    new Guest(1, "Maria", "Gomez","mg@mail.com", "123456" , true , "Medellín" , "Nuevo"),
                    new Guest(2, "Juan", "Perez", "juan@mail.com", "654321" , true , "Bogotá" , "Frecuente")
            )
    );

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
    public Guest findById(int id) {
        return guests.stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Guest> findAll() {
        return guests;
    }

    @Override
    public void deleteById(int id) {
        guests.removeIf(g -> g.getId() == id);
    }
}
