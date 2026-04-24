package application.repository;

import application.domain.BedRoomType;
import application.service.ports.BedRoomTypeRepositoryPort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BedRoomTypeRepository implements BedRoomTypeRepositoryPort {

    // Lista inicial de tipos de habitación
    private final List<BedRoomType> bedRoomTypes = new ArrayList<>(
            Arrays.asList(
                    new BedRoomType(1, "Single"),
                    new BedRoomType(2, "Doble"),
                    new BedRoomType(3, "Suite"),
                    new BedRoomType(4, "Grupal")
            )
    );

    @Override
    public BedRoomType save(BedRoomType bedRoomType) {
        bedRoomTypes.add(bedRoomType);
        return bedRoomType;
    }

    @Override
    public List<BedRoomType> findAll() {
        return bedRoomTypes;
    }

    @Override
    public void deleteById(int idType) {
        bedRoomTypes.removeIf(bt -> bt.getIdType() == idType);
    }

    @Override
    public Optional<BedRoomType> findById(int idType) {
        return bedRoomTypes.stream()
                .filter(bt -> bt.getIdType() == idType)
                .findFirst();
    }
}

