package hotel.application.inputs;

import hotel.domain.BedRoomType;

import java.util.List;
import java.util.Optional;

public interface BedRoomTypeUseCase {

    BedRoomType createBedRoomType(int idType, String type);
    List<BedRoomType> getAllBedRoomTypes();
    Optional<BedRoomType> getBedRoomType(int id);
    BedRoomType updateBedRoomType(int idType, String type);
    void deleteBedRoomType(int id);




}
