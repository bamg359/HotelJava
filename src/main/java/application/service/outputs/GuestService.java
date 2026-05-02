package application.service.outputs;

import application.domain.Guest;
import java.util.List;
import java.util.Optional;

public interface GuestService {
    Guest createGuest(Guest guest);
    Guest updateGuest(Guest guest);
    Optional<Guest> getGuestById(int id);
    List<Guest> getAllGuests();
    boolean deleteGuest(int id);
}
