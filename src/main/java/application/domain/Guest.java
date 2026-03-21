package application.domain;

import java.util.List;
import java.util.Scanner;

public class Guest extends Person {

    Scanner sc = new Scanner(System.in);
    String origen;
    String tipoGuest;

    public Guest(int id, String name, String lastName, String email, String password, Boolean state, String origen, String tipoGuest) {
        super(id, name, lastName, email, password, state);
        this.origen = origen;
        this.tipoGuest = tipoGuest;
    }

    public Guest() {
        super();
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

    @Override
    public String toString() {
        return "Guest{" +
                "sc=" + sc +
                ", origen='" + origen + '\'' +
                ", tipoGuest='" + tipoGuest + '\'' +
                '}';
    }
}
