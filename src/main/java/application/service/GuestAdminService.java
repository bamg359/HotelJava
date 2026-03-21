package application.service;

import application.domain.Guest;
import application.view.GuestView;

import java.util.List;

public interface GuestAdminService {

    public void deleteGuest(int id);

    public List<Guest> getAllGuest(List<GuestView> guestList);

}
