package application.domain;

import java.util.List;
import java.util.Scanner;

public class Guest {

    Scanner sc = new Scanner(System.in);

    Person person;
    String origen;
    String tipoGuest;

    public Guest(Person person, String origen, String tipoGuest) {
        this.person = person;
        this.origen = origen;
        this.tipoGuest = tipoGuest;
    }

    public Guest() {

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

    public Guest create(Guest guest) {
        System.out.println("Creando persona para el huésped");
        Person person = new Person();
        guest.person = person.createUser(person);

        System.out.println("Ingrese el origen del huésped");
        String origen = sc.nextLine();
        guest.origen = origen;

        System.out.println("Ingrese el tipo de huésped");
        String tipo = sc.nextLine();
        guest.tipoGuest = tipo;

        return guest;
    }

    public List<Guest> getAll(List<Guest> guestList) {
        return guestList;
    }

    public void getById(int id, Guest guest) {
        if(guest.person.getId() == id){
            System.out.println("Id: " + guest.person.getId() + "\n" +
                    "Nombre: " + guest.person.getName() + "\n" +
                    "Apellido: " + guest.person.getLastName() + "\n" +
                    "Email: " + guest.person.getEmail() + "\n" +
                    "Origen: " + guest.origen + "\n" +
                    "Tipo: " + guest.tipoGuest + "\n");
        }else{
            System.out.println("Valide el id del huésped que esta consultando");
        }
    }

    public void update(Guest productoEditado) {
    }

    public void delete(int id) {
    }
}
