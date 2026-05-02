package hotel.application;

import hotel.domain.Guest;
import hotel.infraestructure.out.adapter.GuestRepository;
import hotel.application.inputs.GuestAdminService;

import java.util.List;

public class GuestAdminServiceImpl implements GuestAdminService {


    private final GuestRepository guestRepository;

    public GuestAdminServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getGuests() {
        return guestRepository.getAllGuests();
    }

    @Override
    public void deleteGuest(int id) {

    }
}
