package application.service;

import application.domain.BedRoom;
import application.domain.BedRoomType;
import application.service.outputs.BedRoomService;
import application.service.ports.BedRoomRepositoryPort;
import application.service.ports.BedRoomTypeRepositoryPort;

import java.util.List;
import java.util.Optional;

public class BedRoomServiceImp implements BedRoomService {

    private final BedRoomRepositoryPort bedRoomRepositoryPort;
    private final BedRoomTypeRepositoryPort bedRoomTypeRepositoryPort;

    public BedRoomServiceImp(BedRoomRepositoryPort bedRoomRepositoryPort,
                             BedRoomTypeRepositoryPort bedRoomTypeRepositoryPort) {
        this.bedRoomRepositoryPort = bedRoomRepositoryPort;
        this.bedRoomTypeRepositoryPort = bedRoomTypeRepositoryPort;
    }

    @Override
    public BedRoom createBedRoom(BedRoom bedRoom) {
        BedRoomType type = bedRoomTypeRepositoryPort.findById(bedRoom.getBedRoomType().getIdType())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de habitación no encontrado"));
        bedRoom.setBedRoomType(type);
        return bedRoomRepositoryPort.save(bedRoom);
    }

    @Override
    public BedRoom updateBedRoom(int id, BedRoom bedRoom) {
        BedRoom existing = bedRoomRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Habitación no encontrada"));

        BedRoomType type = bedRoomTypeRepositoryPort.findById(bedRoom.getBedRoomType().getIdType())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de habitación no encontrado"));

        existing.setRoom(bedRoom.getRoom());
        existing.setBedRoomType(type);
        existing.setPrice(bedRoom.getPrice());
        existing.setState(bedRoom.getState());

        return bedRoomRepositoryPort.update(id, existing);
    }

    @Override
    public Optional<BedRoom> getBedRoomById(int id) {
        return bedRoomRepositoryPort.findById(id);
    }

    @Override
    public List<BedRoom> getAllBedRooms() {
        return bedRoomRepositoryPort.findAll();
    }

    @Override
    public void deleteBedRoomById(int id) {
        bedRoomRepositoryPort.deleteById(id);
    }
}
