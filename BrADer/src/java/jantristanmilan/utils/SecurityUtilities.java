package jantristanmilan.utils;

import org.mindrot.jbcrypt.BCrypt;

public class SecurityUtilities {

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean isMatch(String candidatePassword,
                                  String hashedPassword) {
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }
}
