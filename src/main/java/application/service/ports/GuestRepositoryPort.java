package application.service.ports;

import application.domain.Guest;
import java.util.List;
import java.util.Optional;

public interface GuestRepositoryPort {
    Guest save(Guest guest);
    Guest update(Guest guest);
    Optional<Guest> findById(int id);
    List<Guest> findAll();
    boolean deleteById(int id);
}
