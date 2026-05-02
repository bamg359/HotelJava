package hotel.infraestructure.out.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {

    T mapRow(ResultSet rs) throws Exception;


}
