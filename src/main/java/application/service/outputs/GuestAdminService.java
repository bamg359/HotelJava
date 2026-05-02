package application.service.outputs;

import application.domain.Guest;
import java.util.List;

// GuestAdminService
public interface GuestAdminService {
    List<Guest> getAllGuests();   //
    boolean deleteGuest(int id);
}





