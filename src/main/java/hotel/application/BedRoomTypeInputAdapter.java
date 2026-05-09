package hotel.application;

import hotel.application.inputs.BedRoomTypeUseCase;
import hotel.application.ports.BedRoomRepositoryPort;
import hotel.application.ports.BedRoomTypeRepositoryPort;
import hotel.domain.BedRoomType;

import java.util.List;

public class BedRoomTypeInputAdapter implements BedRoomTypeUseCase {


    private final BedRoomTypeRepositoryPort bedRoomTypeRepositoryPort;

    public BedRoomTypeInputAdapter(BedRoomTypeRepositoryPort bedRoomTypeRepositoryPort) {
        this.bedRoomTypeRepositoryPort = bedRoomTypeRepositoryPort;
    }

    @Override
    public BedRoomType createBedRoomType(int idType, String type) {

        BedRoomType bedRoomType = new BedRoomType(idType, type);

        bedRoomTypeRepositoryPort.saveBedRoomType(bedRoomType);

        return bedRoomType;
    }

    @Override
    public List<BedRoomType> getAllBedRoomTypes() {
        return List.of();
    }
}
