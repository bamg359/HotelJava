package application.repository;

import application.domain.Booking;

import java.util.List;
import java.util.Scanner;

public class BedRoomRepository {


    Scanner sc = new Scanner(System.in);


    private int roomId;
    private String room;
    private String roomType;
    private double price;
    private boolean state;

    public BedRoomRepository(){

    }

    public BedRoomRepository(int roomId, String room, String roomType, double price, boolean state) {
        this.roomId = roomId;
        this.room = room;
        this.roomType = roomType;
        this.price = price;
        this.state = state;
    }

    public BedRoomRepository(String room) {
        this.room = room;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public BedRoomRepository createBedRoom(BedRoomRepository bedRoom){


        System.out.println("Ingrese el id de la habitación");
        int id = sc.nextInt();
        bedRoom.roomId = id;
        sc.nextLine();

        System.out.println("Ingrese el numero de la Habitacion");
        String room = sc.nextLine();
        bedRoom.room = room;

        System.out.println("Seleccione el tipo de la habitación");
        String roomType = sc.nextLine();
        bedRoom.roomType = roomType;

        System.out.println("Ingrese el precio por persona ");
        double price = sc.nextDouble();
        bedRoom.price = price;
        sc.nextLine();

        System.out.println("Seleccione el estado de la habitación");
        boolean state = sc.nextBoolean();
        bedRoom.state = state;



        return bedRoom;
    }

    public List<BedRoomRepository> getAllBedRoom(List<BedRoomRepository> bedRoomList){
        return bedRoomList;
    }

    public void getBedRoomById(int id , BedRoomRepository bedRoom){

        if(this.roomId == id){
            System.out.println("Id:" + bedRoom.roomId + "\n" +
                    "Num Hab: " + bedRoom.room + "\n" +
                    "Tipo hab: " + bedRoom.roomType + "\n" +
                    "Precio" + bedRoom.price + "\n" +
                    "Estado:"  + bedRoom.state + "\n");


        }else{
            System.out.println("Valide el id de la habitacion que esta consultando");
        }

    }

    public void update(Booking productoEditado) {
    }

    public void delete(int id) {
    }


}
