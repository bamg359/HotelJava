package application.service;

import application.domain.Guest;

import java.util.Optional;

public interface GuestService {

    Guest createGuest(Guest guest);

    Guest updateGuest(Guest guest);

    Optional<Guest> getGuestsById(int id);

}
