package jantristanmilan.data;

import com.sun.org.apache.bcel.internal.generic.Select;
import jantristanmilan.data.User;
import jantristanmilan.data.UserDAO;
import jantristanmilan.utils.DatabaseUtilities;
import jantristanmilan.utils.SecurityUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLUserDAO implements UserDAO {
    private static Connection dbConnection =
            DatabaseUtilities.getConnection("ptf_brad");

    public void create(User user) {
        try {
            String sql = "INSERT INTO users(username, password," +
                    " first_name, last_name, email) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = dbConnection.prepareStatement(sql);

            statement.setString(1, user.getUsername());
            statement.setString(2,
                    SecurityUtilities.hashPassword(user.getPassword()));
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getEmail());

            
            System.out.println(statement.execute());
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User get(String username) {
        User user = null;

        try {
            String sql = "SELECT * " +
                         "FROM users " +
                         "WHERE username = ? ";
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
