package cbs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cbs.Transaction;
import cbs.enums.TransactionStatus;
import cbs.enums.TransactionType;

public class TransactionOperation {
    private static final Connection connection = DatabaseConnection.getInstance().getConnection();

    // Insert new Transaction
    public static void insert(Transaction transaction) throws SQLException{
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction object cannot be null");
        }

        String sql = "INSERT INTO `transaction` (`account_id`, `amount`, `date`, `type`, `status`)"
                    + "VALUES (?, ?, ?, ?, ?);";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transaction.get_account_id());
            stmt.setDouble(2, transaction.get_amount());
            stmt.setTimestamp(3, transaction.get_transaction_date());
            stmt.setString(4, transaction.get_type());
            stmt.setString(5, transaction.get_status());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("New Transaction created successfully!");
            }
        }
    }

    // Get transaction
    public static Transaction select(int ID) throws SQLException {
        String sql = "SELECT * FROM `transaction` WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ID);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Transaction(ID, rs.getInt("account_id"), rs.getTimestamp("date"), rs.getDouble("amount"), TransactionStatus.valueOf(rs.getString("status")), TransactionType.valueOf(rs.getString("type")));
                }
            }
        }
        return null;
    }

    // Get all transactions
    public static List<Transaction> get_all(int account_id) throws SQLException {
        List<Transaction> transactions = new ArrayList<Transaction>();

        String sql = "SELECT * FROM `transaction` WHERE account_id = ? ORDER BY `date` ASC";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, account_id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = new Transaction(
                        rs.getInt("id"),
                        rs.getInt("account_id"),
                        rs.getTimestamp("date"),
                        rs.getDouble("amount"),
                        TransactionStatus.valueOf(rs.getString("status")),
                        TransactionType.valueOf(rs.getString("type")),
                        rs.getInt("recipient_account_id")
                    );
                    transactions.add(transaction);
                }

                return transactions;
            }
        }
    }
}
