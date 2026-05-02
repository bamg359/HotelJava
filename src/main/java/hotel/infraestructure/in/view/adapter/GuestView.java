package hotel.infraestructure.in.view.adapter;

import hotel.domain.Guest;
import hotel.application.inputs.GuestAdminService;
import hotel.application.inputs.GuestService;

public class GuestView {

    private final GuestService guestService;
    private final GuestAdminService guestAdminService;
    private final Guest guest;

    public GuestView(GuestService guestService, Guest guest , GuestAdminService guestAdminService) {
        this.guestAdminService = guestAdminService;
        this.guestService = guestService;
        this.guest = guest;
    }

    public void createGuest(){


        guestService.createGuest(guest);

    }

    public void getAllGuests(){
        guestAdminService.getGuests();
    }





}
