package application.repository;

import application.domain.Guest;
import java.util.ArrayList;
import java.util.List;

public class GuestRepository {
    private final List<Guest> guests = new ArrayList<>();

    public GuestRepository() {
        // Datos iniciales
        guests.add(new Guest(1, "Maria", "Gomez", "mg@mail.com", "123456", true, "Medellín", "Nuevo"));
        guests.add(new Guest(2, "Juan", "Perez", "juan@mail.com", "654321", false, "Envigado", "Frecuente"));
    }

    public Guest save(Guest guest) {
        guests.add(guest);
        return guest;
    }

    public Guest update(int id, Guest guest) {
        deleteById(id);
        guests.add(guest);
        return guest;
    }

    public Guest findById(int id) {
        return guests.stream().filter(g -> g.getId() == id).findFirst().orElse(null);
    }

    public List<Guest> findAll() {
        return new ArrayList<>(guests);
    }

    public void deleteById(int id) {
        guests.removeIf(g -> g.getId() == id);
    }
}
