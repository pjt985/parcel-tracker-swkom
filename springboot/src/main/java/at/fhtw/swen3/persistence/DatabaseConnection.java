package at.fhtw.swen3.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection conn;
    private final String dbUrl;
    private final String dbUsername;
    private final String dbPassword;


    public DatabaseConnection() {
        dbUrl = "jdbc:h2:file:./data/demo";
        dbUsername = "sa";
        dbPassword = "password";
    }


    public Connection createConnection() throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        return conn;
    }
}
