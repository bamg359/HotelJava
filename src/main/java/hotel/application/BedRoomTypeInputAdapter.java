package hotel.application;

import hotel.application.inputs.BedRoomTypeUseCase;
import hotel.application.ports.BedRoomRepositoryPort;
import hotel.application.ports.BedRoomTypeRepositoryPort;
import hotel.domain.BedRoomType;

import java.util.List;
import java.util.Optional;

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

        return bedRoomTypeRepositoryPort.findAllBedRoomTypes();
    }

    @Override
    public Optional<BedRoomType> getBedRoomType(int id) {

        BedRoomType bedRoomType = bedRoomTypeRepositoryPort.findBedRoomTypeById(id).orElseThrow();

        return Optional.of(bedRoomType);
    }

    @Override
    public BedRoomType updateBedRoomType(int idType, String type) {

        Optional<BedRoomType> bedRoomType = bedRoomTypeRepositoryPort.findBedRoomTypeById(idType);

        if(bedRoomType.isPresent()){

            BedRoomType bedRoomType1 = bedRoomType.get();


        }

        return null;
    }

    @Override
    public void deleteBedRoomType(int id) {

    }
}
