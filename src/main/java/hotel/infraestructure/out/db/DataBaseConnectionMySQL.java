package hotel.infraestructure.out.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionMySQL {

    private final Connection connection;
    private static DataBaseConnectionMySQL instance;

    private static final String URL = "jdbc:mysql://localhost:3306/hotel_java";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private DataBaseConnectionMySQL(){

        try{

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully!");

        }catch (SQLException e){
            throw new RuntimeException("Error connecting to the database: " + e.getMessage());
        }
    }

    public static synchronized DataBaseConnectionMySQL getInstance() {
        if (instance == null) {
            instance = new DataBaseConnectionMySQL();
        }
        return instance;
    }


    public Connection getConnection() {
        return connection;
    }

}
