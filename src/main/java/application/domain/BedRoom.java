package application.domain;

import java.util.Scanner;

public class BedRoom {

    Scanner sc = new Scanner(System.in);

   private int roomId;
   private String room;
   private String roomType;
   private double price;
   private boolean state;

   // Constructors

    public BedRoom(){

    }

    public BedRoom(int roomId, boolean state, double price, String room, String roomType) {
        this.roomId = roomId;
        this.state = state;
        this.price = price;
        this.room = room;
        this.roomType = roomType;
    }

    public BedRoom(String room) {
        this.room = room;
    }

    // getter


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    // methods
    public BedRoom createBedRoom(BedRoom bedRoom){

        System.out.println(" ingrese el id dde la habitacion ");
        int id = sc.nextInt();
        bedRoom.roomId = id;
        sc.nextLine();

        System.out.println(" ingrese el numero de la habitacion ");
        String room = sc.nextLine();
        bedRoom.room = room;

        System.out.println(" seleccione el tipo de la habitacion ");
        String roomType = sc.nextLine();
        bedRoom.roomType = roomType;

        System.out.println(" ingrese el precio por persona ");
        double price = sc.nextDouble();
        bedRoom.price = price;
        sc.nextLine();

        System.out.println(" seleccione el estado de la habitacion ");
        boolean state = sc.nextBoolean();
        bedRoom.state = state;

        return bedRoom;
    }

    public  void getBedRoomById(int id,BedRoom bedRoom){

        if (this.roomId == id){
            System.out.println("id : " + bedRoom.roomId + "\n"+" numero habitacion " + bedRoom.room + "\n" +
                    " tipo de habitacion " + bedRoom.roomType + " \n" +
                    " precio " + bedRoom.price + "\n" +
                    " estado " + bedRoom.state + " \n");
        }else {
            System.out.println(" valide la id de la habitacion que esta consultando ");
        }

    }
}

