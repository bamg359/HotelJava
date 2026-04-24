package application.service.ports;

import application.domain.BedRoomType;
import java.util.List;
import java.util.Optional;

public interface BedRoomTypeRepositoryPort {
    BedRoomType save(BedRoomType bedRoomType);
    List<BedRoomType> findAll();
    void deleteById(int idType);
    Optional<BedRoomType> findById(int idType);
}
