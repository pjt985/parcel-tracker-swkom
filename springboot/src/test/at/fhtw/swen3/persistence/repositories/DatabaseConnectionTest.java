package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.DatabaseConnection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    @Test
    void createConnectionTest() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        assertDoesNotThrow(() -> databaseConnection.createConnection());
    }
}
