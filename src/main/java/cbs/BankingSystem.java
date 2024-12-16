package cbs;


import java.sql.SQLException;

// import cbs.db.UserOperation;
// import cbs.enums.UserRole;
import cbs.gui.LoginFrame;

public class BankingSystem {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }
}
