package hotel.infraestructure.out.mapper;

import hotel.domain.BedRoom;

import java.sql.ResultSet;

public class BedRoomRowMapper implements RowMapper{

    @Override
    public BedRoom mapRow(ResultSet rs) throws Exception {
        BedRoom bedRoom = new BedRoom();
        bedRoom.setRoomId(rs.getInt("room_id"));
        bedRoom.setRoom(rs.getString("room"));
        bedRoom.setPrice(rs.getDouble("price"));
        bedRoom.setState(rs.getString("state"));
        return bedRoom;
    }
}
