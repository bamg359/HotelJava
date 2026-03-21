package application.view;

import application.domain.Guest;
import application.service.GuestServiceImplementation;

public class GuestView {

    private final GuestServiceImplementation guestServiceImplementation;

    private final Guest guest;

    public GuestView(GuestServiceImplementation guestServiceImplementation, Guest guest) {
        this.guestServiceImplementation = guestServiceImplementation;
        this.guest = guest;
    }


    public void createGuest(){

        guestServiceImplementation.createGuest(guest);

    }

}
