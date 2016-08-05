package jantristanmilan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtilities {
    private static final String USERNAME = "root";
    private static final String PASSWORD ="admin";

    public static Connection getConnection(String schemaName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + schemaName
                    + "?autoReconnect=true&useSSL=true";
            return DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
