package hotel.infraestructure.out.adapter;

import hotel.application.ports.BedRoomTypeRepositoryPort;
import hotel.domain.BedRoomType;
import hotel.infraestructure.out.mapper.BedRoomRowMapper;
import hotel.infraestructure.out.mapper.BedRoomTypeRowMapper;
import hotel.infraestructure.out.mapper.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BedRoomTypeRepositoryDB implements BedRoomTypeRepositoryPort {


    private final Connection connection;
    private final BedRoomTypeRowMapper bedRoomTypeRowMapper;

    public BedRoomTypeRepositoryDB(Connection connection, BedRoomTypeRowMapper bedRoomTypeRowMapper) {
        this.bedRoomTypeRowMapper = bedRoomTypeRowMapper;
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

        String sql = "SELECT * FROM bed_room_type WHERE id_type = ? ";

        try(PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return Optional.of(bedRoomTypeRowMapper.mapRow(rs));
            }

        }catch(SQLException e){

            throw new RuntimeException("No se encontró el id del tipo de habitación" + e.getMessage());

        }
        return Optional.empty();
    }

    @Override
    public List<BedRoomType> findAllBedRoomTypes() {

        List<BedRoomType> bedRoomTypeList = new ArrayList<>();

        String sql = "SELECT * FROM bed_room_type";

        try(PreparedStatement ps = connection.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                bedRoomTypeList.add(bedRoomTypeRowMapper.mapRow(rs));
            }

        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los tipos de habitacion", e);
        }

        return bedRoomTypeList;
    }

    @Override
    public BedRoomType updateBedRoomType(int id, BedRoomType bedRoomType) {

        String sql = "UPDATE bed_room_type SET type = ? WHERE id_type = ?";

        try(PreparedStatement ps= connection.prepareStatement(sql)){

            setBedRoomTypeParams(ps, bedRoomType);

            ps.setInt(2, bedRoomType.getIdType());

            ps.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException("No se puedo actualizar el tipo" + e.getMessage());

        }
        return bedRoomType;
    }

    @Override
    public void deleteBedRoomTypeById(int id) {

        String sql = "DELETE from bed_room_type WHERE id_type = ?";

        try(PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException("No fue posible eliminar el tipo");
        }

    }

    //Helper method to map ResultSet to BedRoomType


    private void setBedRoomTypeParams(PreparedStatement ps, BedRoomType bedRoomType) throws SQLException {

        ps.setInt(1, bedRoomType.getIdType());
        ps.setString(2, bedRoomType.getType());

    }




}
