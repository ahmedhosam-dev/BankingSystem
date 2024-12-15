package cbs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import cbs.Account;
import cbs.enums.AccountStatus;

public class AccountOperation {
    private static final Connection connection = DatabaseConnection.getInstance().getConnection();

    // Insert new account 
    public static void insert(Account account) throws SQLException {
        if (account == null) {
            throw new IllegalArgumentException("Account object cannot be null");
        }

        String sql = "INSERT INTO `account`(`customer_id`, `status`, `balance`) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, account.get_customer_id());
            stmt.setString(2, account.get_status());
            stmt.setDouble(3, account.get_balance());

            if (stmt.executeUpdate() > 0) {
                System.out.println("New Account createdd successfully!");
            }
        }
    }

    // Get account
    public static Account select(int ID) throws SQLException {
        String sql = "SELECT * FROM account WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ID);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Account(ID, rs.getInt("customer_id"), rs.getDouble("balance"), AccountStatus.valueOf(rs.getString("status")), rs.getTimestamp("created_at"), rs.getTimestamp("updated_at"));
                }
            }
        }
        return null;
    }


    // Update account data
    public static void update(Account account) throws SQLException {
        String sql = "UPDATE `account` SET `status`=? ,`balance`=?, `updated_at`=? WHERE id = ?";

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, account.get_status());
            stmt.setDouble(2, account.get_balance());
            stmt.setTimestamp(3, currentTime);
            stmt.setInt(4, account.get_id());

            if (stmt.executeUpdate() > 0) {
                System.out.println("Updated account successfully!");
            }
        }
    }

    // Delete account 
    public static void delete(int ID) throws SQLException {
        String sql = "DELETE FROM `account` WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ID);

            if (stmt.executeUpdate() > 0) {
                System.out.println("Deleted account successfully!");
            }
        }
    }
}
