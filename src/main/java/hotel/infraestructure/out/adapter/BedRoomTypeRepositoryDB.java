package hotel.infraestructure.out.adapter;

import hotel.application.ports.BedRoomTypeRepositoryPort;
import hotel.domain.BedRoomType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class BedRoomTypeRepositoryDB implements BedRoomTypeRepositoryPort {


    private final Connection connection;

    public BedRoomTypeRepositoryDB(Connection connection) {
        this.connection = connection;
    }


    @Override
    public BedRoomType saveBedRoomType(BedRoomType bedRoomType) {

        String sql = "INSERT INTO bed_room_type (id_type, type) VALUES (?, ?)";

        try(PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){

            setBedRoomTypeParams(ps, bedRoomType);
            ps.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException("Error al guardar tipo de habitación: " + e.getMessage(), e);

        }

        return bedRoomType;
    }

    @Override
    public Optional<BedRoomType> findBedRoomTypeById(int id) {
        return Optional.empty();
    }


    //Helper method to map ResultSet to BedRoomType


    private void setBedRoomTypeParams(PreparedStatement ps, BedRoomType bedRoomType) throws SQLException {

        ps.setInt(1, bedRoomType.getIdType());
        ps.setString(2, bedRoomType.getType());

    }




}
