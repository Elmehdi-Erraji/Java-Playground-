package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:postgresql://localhost:5432/debreefing";
    private static final String USER = "debreefingDB";
    private static final String PASSWORD = "";

    private static final Database INSTANCE = new Database();
    private final Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database successfully");
        } catch (SQLException e) {
            throw new RuntimeException("Could not connect to database", e);
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void testConnection() {
        try {
            Database db = Database.getInstance();
            if (db.getConnection() != null && !db.getConnection().isClosed()) {
                System.out.println("Database connection is active.");
            } else {
                System.out.println("Database connection is not active.");
            }
        } catch (SQLException e) {
            System.out.println("Error checking database connection: " + e.getMessage());
        }
    }
}
