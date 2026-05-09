package hotel.application.inputs;

import hotel.domain.BedRoomType;

import java.util.List;

public interface BedRoomTypeUseCase {

    BedRoomType createBedRoomType(int idType, String type);
    List<BedRoomType> getAllBedRoomTypes();




}
