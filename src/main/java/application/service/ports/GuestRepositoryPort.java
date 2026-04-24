package application.service.ports;

import application.domain.Guest;

import java.util.List;


    public interface GuestRepositoryPort {
        Guest save(Guest guest);
        Guest update(Guest guest);
        Guest findById(int id);   // usar int
        List<Guest> findAll();
        void deleteById(int id);  // usar int
    }


