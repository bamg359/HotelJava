package application.service;

import application.domain.Guest;

import java.util.Optional;
import java.util.Scanner;

public class GuestServiceImplementation implements GuestService{

    Scanner sc = new Scanner(System.in);

    @Override
    public Guest createGuest(Guest guest) {

        System.out.println("Ingrese el id del huesped");
        int id = sc.nextInt();
        guest.setId(id);

        System.out.println("Ingrese el nombre");
        String name = sc.next();
        guest.setName(name);

        System.out.println("Ingrese el apellido");
        String lastName = sc.next();
        guest.setLastName(lastName);

        System.out.println("Ingrese el email");
        String email = sc.next();
        guest.setEmail(email);

        System.out.println("Ingrese la contraseña");
        String password = sc.next();
        guest.setPassword(password);

        guest.setState(true);

        System.out.println("Ingrese el origen del huesped");
        String origen = sc.next();
        guest.setOrigen(origen);

        System.out.println("Ingrese el tipo de huesped");
        String guestType = sc.next();
        guest.setTipoGuest(guestType);

        return null;
    }

    @Override
    public Guest updateGuest(Guest guest) {
        return null;
    }

    @Override
    public Optional<Guest> getGuestsById(int id) {
        return Optional.empty();
    }
}
