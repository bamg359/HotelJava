package application.service.ports;

import application.domain.BedRoom;
import java.util.List;
import java.util.Optional;

public interface BedRoomRepositoryPort {
    BedRoom save(BedRoom bedRoom);
    List<BedRoom> findAll();
    Optional<BedRoom> findById(int id);
    void deleteById(int id);
    BedRoom update(int id, BedRoom bedRoom);
}


