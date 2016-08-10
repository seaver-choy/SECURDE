package model;

import dao.LoginDAO;
import db_connection.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Account;

public class LoginModel implements LoginDAO{
    @Override
    public Account getAccount(String username, String password) {
        Account account = null;
        
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM accounts WHERE username = ? AND password = ?;";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rsList = statement.executeQuery();
            conn.commit();
            
            if(rsList.next()) {
                account = new Account(rsList.getInt("account_id"),
                                 rsList.getString("username"),
                                 rsList.getString("password"),
                                 rsList.getString("role"),
                                 rsList.getString("name"),
                                 rsList.getString("email"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        } return account;
    }
}
