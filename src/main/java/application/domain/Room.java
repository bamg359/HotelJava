package application.domain;

import application.domain.enums.RoomStatus;
import java.util.Scanner;

public class Room {

    private int roomId;
    private String room;
    private String roomType;
    private double price;
    private RoomStatus roomStatus;


    Scanner sc = new Scanner(System.in);

    // Constructor
    public Room(int roomId, String room, String roomType, double price, RoomStatus roomStatus) {
        this.roomId = roomId;
        this.room = room;
        this.roomType = roomType;
        this.price = price;
        this.roomStatus = roomStatus;
    }

    // Getters and Setters

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

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    // Methods

    public Room createRoom(Room room) {

        System.out.println("Enter Room ID");
        room.setRoomId(sc.nextInt());
        sc.nextLine();

        System.out.println("Enter Room number");
        room.setRoom(sc.nextLine());

        System.out.println("Enter Room type");
        room.setRoomType(sc.nextLine());

        System.out.println("Enter Room price");
        room.setPrice(sc.nextDouble());
        sc.nextLine();

        System.out.println("Enter Room Status (AVAILABLE, RESERVED, OCCUPIED, MAINTENANCE):");
        String statusInput = sc.nextLine().toUpperCase();

        try {
            RoomStatus status = RoomStatus.valueOf(statusInput);
            room.setRoomStatus(status);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status. Defaulting to AVAILABLE.");
            room.setRoomStatus(RoomStatus.AVAILABLE);
        }

        return room;
    }

    public void getRoomById(int id, Room room) {
        if (room.getRoomId() == id) {
            System.out.println("Id: " + room.getRoomId() + "\n" +
                    "Room number: " + room.getRoom() + "\n" +
                    "Room type: " + room.getRoomType() + "\n" +
                    "Room price: " + room.getPrice() + "\n" +
                    "Room status: " + room.getRoomStatus() + "\n");
        } else {
            System.out.println("Invalid Room ID");
        }
    }
}