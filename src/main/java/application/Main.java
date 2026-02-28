package application;

import application.domain.BedRoom;
import application.domain.Person;

public class Main {

    public static void main(String[] args) {

        Person person = new Person("jd@med.com");

        /*
        person.setId(1);
        person.setName("John");
        person.setLastName("Doe");
        //person.setEmail("jd@mail.com");
        person.setPassword("123456");
        person.setState(true);

        System.out.println(person.getId());
        System.out.println(person.getName());
        System.out.println(person.getEmail());
        */

        BedRoom bedRoom = new BedRoom();

        bedRoom.createBedRoom(bedRoom);

        bedRoom.getBedRoomById(1, bedRoom);

    }
}
