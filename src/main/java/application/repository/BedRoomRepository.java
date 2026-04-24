package application.repository;

import application.domain.BedRoom;
import application.domain.BedRoomType;
import application.service.ports.BedRoomRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BedRoomRepository implements BedRoomRepositoryPort {

    private final List<BedRoom> bedRooms = new ArrayList<>();

    public BedRoomRepository() {
        bedRooms.add(new BedRoom(201, "201", new BedRoomType(1,"Single"),120000,"DISPONIBLE"));
        bedRooms.add(new BedRoom(202, "202", new BedRoomType(2,"Doble"),180000,"OCUPADA"));
        bedRooms.add(new BedRoom(203, "203", new BedRoomType(3,"Suite"),240000,"RESERVADA"));
    }

    @Override
    public BedRoom save(BedRoom bedRoom) {
        bedRooms.add(bedRoom);
        return bedRoom;
    }

    @Override
    public List<BedRoom> findAll() {
        return bedRooms;
    }

    @Override
    public Optional<BedRoom> findById(int id) {
        return bedRooms.stream()
                .filter(b -> b.getRoomId() == id)
                .findFirst();
    }

    @Override
    public void deleteById(int id) {
        bedRooms.removeIf(b -> b.getRoomId() == id);
    }

    @Override
    public BedRoom update(int id, BedRoom bedRoom) {
        for (int i = 0; i < bedRooms.size(); i++) {
            if (bedRooms.get(i).getRoomId() == id) {
                bedRooms.set(i, bedRoom);
                return bedRoom;
            }
        }
        throw new IllegalArgumentException("Habitación con Id " + id + " no encontrada");
    }
}
