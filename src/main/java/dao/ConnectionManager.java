package dao;
import java.sql.*;

public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost/Biblioteca";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

