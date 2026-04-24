package application.domain;

public class BedRoom {

    private int roomId;
    private String room;
    private BedRoomType bedRoomType;
    private double price;
    private String state;

    public BedRoom() {}

    public BedRoom(int roomId, String room, BedRoomType bedRoomType, double price, String state) {
        this.roomId = roomId;
        this.room = room;
        this.bedRoomType = bedRoomType;
        this.price = price;
        this.state = state;
    }

    // --- Getters y Setters ---
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

    public BedRoomType getBedRoomType() {
        return bedRoomType;
    }

    public void setBedRoomType(BedRoomType bedRoomType) {
        this.bedRoomType = bedRoomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

