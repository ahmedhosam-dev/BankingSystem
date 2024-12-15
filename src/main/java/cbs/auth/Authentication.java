package cbs.auth;

import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import cbs.User;
import cbs.db.UserOperation;

public class Authentication {
    // Check if user authorized or not
    public static boolean check_auth(String username, String password) throws SQLException {
        User user = UserOperation.select(username);
        
        if (check_password(password, user.get_password())) {
            return true;
        }

        return false;
    }

    // Hashing the original password
    public static String hash_password(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Check password is correct or not
    public static boolean check_password(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
