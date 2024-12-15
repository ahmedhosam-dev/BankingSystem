package cbs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cbs.Transfer;
import cbs.enums.TransactionStatus;

public class TransferOperation {
    private static final Connection connection = DatabaseConnection.getInstance().getConnection();
    
    // Insert new transfer
    public static void insert(Transfer transfer) throws SQLException {
        if (transfer == null) {
            throw new IllegalArgumentException("Transfer object cannot be null");
        }
        
        String sql = "INSERT INTO `transfare`(`sender_account_id`, `recipient_account_id`, `amount`, `date`, `status_id`)"
                    + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transfer.get_account_id());
            stmt.setInt(2, transfer.get_account_id());
            stmt.setDouble(3, transfer.get_amount());
            stmt.setTimestamp(4, transfer.get_transaction_date());
            stmt.setString(5, transfer.get_status());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("New Transfer created successfully!");
            }
        }
    }

    // Get transfer data
    public static Transfer select(int ID) throws SQLException {
        String sql = "SELECT * FROM `transfer` WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ID);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Transfer(ID, rs.getInt("sender_account_id"), rs.getTimestamp("date"), rs.getDouble("amount"), TransactionStatus.valueOf(rs.getString("status")), rs.getInt("recipient_account_id"));
                }
            }
        }
        return null;
    }
}
