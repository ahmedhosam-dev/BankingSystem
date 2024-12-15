package cbs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cbs.User;
import cbs.enums.UserRole;

public class UserOperation {
    private static final Connection connection = DatabaseConnection.getInstance().getConnection();

    // Insert new user
    public static void insert(User user) throws SQLException {
        if (user == null) {
            throw new IllegalArgumentException("User object cannot be null");
        }

        String sql = "INSERT INTO `user`(`name`, `password`, `full_name`, `email`, `role`)" 
                    + "VALUES (?, ?, ?, ?, ?)";
                
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.get_name());
            stmt.setString(2, user.get_password());
            stmt.setString(3, user.get_full_name());
            stmt.setString(4, user.get_email());
            stmt.setString(5, user.get_role().name());

            if (stmt.executeUpdate() > 0) {
                System.out.println("New user created successfully!");
            }
        }
    }

    // Get user from database
    public static User select(int ID) throws SQLException {
        String sql = "SELECT * FROM `user` WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ID);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(ID, rs.getString("name"), rs.getString("full_name"), rs.getString("email"), rs.getString("password"), UserRole.valueOf(rs.getString("role")));
                }
            }
        }
        return null;
    }

    // Get user by name from database
    public static User select(String name) throws SQLException {
        String sql = "SELECT * FROM `user` WHERE name = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("name"), rs.getString("full_name"), rs.getString("email"), rs.getString("password"), UserRole.valueOf(rs.getString("role")));
                }
            }
        }
        return null;
    }

}
