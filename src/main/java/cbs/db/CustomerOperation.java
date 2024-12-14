package cbs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cbs.Customer;
import cbs.enums.CustomerStatus;

public class CustomerOperation {
    private static final Connection connection = DatabaseConnection.getInstance().getConnection();
    
    // Insert new customer
    public static void insert(Customer customer) throws SQLException {
        if (customer == null) {
            throw new IllegalArgumentException("Customer object cannot be null");
        }
        String sql = "INSERT INTO `customer` (`name`, `full_name`, `birthday`, `email`, `phone_number`, `address`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, customer.get_name());
            stmt.setString(2, customer.get_full_name());
            stmt.setString(3, customer.get_birthday());
            stmt.setString(4, customer.get_email());
            stmt.setString(5, customer.get_phone_number());
            stmt.setString(6, customer.get_address());
            stmt.setString(7, customer.get_status());

            if (stmt.executeUpdate() > 0){
                System.out.println("New customer created successfully!");
            }
        }
    }

    // Get customer 
    public static Customer select(int ID) throws SQLException {
        String sql = "SELECT * FROM `customer` WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ID);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Customer(ID, rs.getString("name"), rs.getString("full_name"), rs.getString("email"), rs.getDate("birthday").toString(), rs.getString("phone_number"), rs.getString("address"), CustomerStatus.valueOf(rs.getString("status")));
                }
            }
        }
        return null;
    }

    // Update customer data
    public static void update(Customer customer) throws SQLException {
        String sql = "UPDATE `customer` SET `name`=?, `full_name`=? ,`email`=?, `phone_number`=?, `address`=?, `status`=? WHERE id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, customer.get_name());
            stmt.setString(2, customer.get_full_name());
            stmt.setString(3, customer.get_email());
            stmt.setString(4, customer.get_phone_number());
            stmt.setString(5, customer.get_address());
            stmt.setString(6, customer.get_status());
            stmt.setInt(7, customer.get_id());

            if (stmt.executeUpdate() > 0) {
                System.out.println("Updated customer successfully!");
            }
        }
    }

    // Delete cutomer 
    public static void delete(int ID) throws SQLException {
        String sql = "DELETE FROM `customer` WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ID);

            if (stmt.executeUpdate() > 0) {
                System.out.println("Deleted customer successfully!");
            }
        }
    }
}
