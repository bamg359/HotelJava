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
    public BedRoom createBedRoom( BedRoom bedRoom) {
        if (bedRoomRepositoryPort.findById(bedRoom.getRoomId()).isPresent()) {
            throw new IllegalArgumentException("La habitación con ID " + bedRoom.getRoomId() + " ya existe.");
        }


        BedRoomType officialType = findOfficialType(bedRoom.getBedRoomType().getIdType());
        bedRoom.setBedRoomType(officialType);


        return bedRoomRepositoryPort.saveBedRoom(bedRoom);
    }


    @Override
    public BedRoom updateBedRoom(BedRoom bedRoom) {
        if (bedRoomRepositoryPort.findById(bedRoom.getRoomId()).isEmpty()) {
            throw new IllegalArgumentException("No se puede actualizar: la habitación no existe.");
        }


        BedRoomType officialType = findOfficialType(bedRoom.getBedRoomType().getIdType());
        bedRoom.setBedRoomType(officialType);

        return bedRoomRepositoryPort.updateBedRoom(bedRoom);
    }


    private BedRoomType findOfficialType(int typeId) {
        return bedRoomTypeRepositoryPort.findById(typeId)
                .orElseThrow(() -> new IllegalArgumentException("Tipo de habitación no encontrado"));
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
        bedRoomRepositoryPort.deleteBedRoomById(id);
    }
}
