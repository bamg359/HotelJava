package application.service.ports;

import application.domain.BedRoom;
import java.util.List;
import java.util.Optional;

public interface BedRoomRepositoryPort {
    BedRoom saveBedRoom (BedRoom bedRoom);
    List<BedRoom> findBedRoomAll();
    Optional<BedRoom> findBedRoomById(int id);
    void deleteBedRoomById(int id);
    BedRoom updateBedRoom(BedRoom bedRoom);

    }


