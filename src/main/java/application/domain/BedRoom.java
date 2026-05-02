package application.domain;

import application.domain.enums.BedRoomState;

public class BedRoom {

    private int roomId;
    private String room;
    private BedRoomType bedRoomType;
    private double price;
    private BedRoomState bedRoomState;

    public BedRoom() {
    }

    public BedRoom(int roomId, String room, BedRoomType bedRoomType, double price, BedRoomState state) {
        this.roomId = roomId;
        this.room = room;
        this.bedRoomType = bedRoomType;
        this.price = price;
        this.bedRoomState = state;
    }
    public BedRoom(String room) {
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

    public BedRoomState getBedRoomState() {
        return bedRoomState;
    }

    public void setBedRoomState(BedRoomState bedRoomState) {
        this.bedRoomState = bedRoomState;
    }

    @Override
    public String toString() {
        return "BedRoom{" +
                "roomId=" + roomId +
                ", room='" + room + '\'' +
                ", bedRoomType=" + bedRoomType.getType() +
                ", price=" + price +
                ", state=" + bedRoomState +
                '}';
    }
}