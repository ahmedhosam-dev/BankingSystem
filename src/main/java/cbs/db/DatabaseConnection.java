package cbs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConnection{
    private static volatile DatabaseConnection instance;
    private Connection connection;

    private static final Dotenv dotenv = Dotenv.load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Failed to connect to the database!");
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null ) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Database connection closed!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, world! from dbc class.");
        // Test connet again with dotenv
        String sql = "SELECT * FROM status";
        try {
            ResultSet result= DatabaseConnection.getInstance().getConnection().createStatement().executeQuery(sql);
            System.out.println("Records from the 'name' column:");
            while (result.next()) {
                String name = result.getString("name");
                System.out.println(name);
            }
            DatabaseConnection.getInstance().closeConnection();
        }
        catch (SQLException e) {
            throw new RuntimeException("Error while get data from database");
        }

    }
}
