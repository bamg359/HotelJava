package application.repository;

import application.domain.Person;

import java.util.List;
import java.util.Scanner;

public class GuestRepository {

    Scanner sc = new Scanner(System.in);

    Person person;
    String origen;
    String tipoGuest;

    public GuestRepository(Person person, String origen, String tipoGuest) {
        this.person = person;
        this.origen = origen;
        this.tipoGuest = tipoGuest;
    }

    public GuestRepository() {

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getTipoGuest() {
        return tipoGuest;
    }

    public void setTipoGuest(String tipoGuest) {
        this.tipoGuest = tipoGuest;
    }

    public GuestRepository create(GuestRepository guest) {

        return guest;
    }

    public List<GuestRepository> getAll(List<GuestRepository> guestList) {
        return guestList;
    }

    public void getById(int id, GuestRepository guest) {
    }

    public void update(GuestRepository productoEditado) {
    }

    public void delete(int id) {
    }
}
