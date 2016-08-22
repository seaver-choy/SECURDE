package com.mycompany.securde1.model;

import dao.LoginDAO;
import com.mycompany.securde1.db_connection.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Account;
import object.Log;

public class LoginModel implements LoginDAO{
    @Override
    public Account login(String username, String password) {
        Account account = null;
        
        if(checkIfExists(username)){
            try {
                Connection conn = MySQLConnector.getConnection();
                PreparedStatement statement = null;
                String query = "SELECT * FROM kickaj.accounts WHERE username = ? AND password = ?;";
                
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
                ex.printStackTrace();
            } 
        }
        return account;
    }

    @Override
    public boolean register(Account customer){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SS");
        DateFormat idFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss-SS");
        String datetime = dateFormat.format(new Date());
        String id = idFormat.format(new Date());
        
        if(!checkIfExists(customer.getUsername())){
            try {
                Connection conn = MySQLConnector.getConnection();
                PreparedStatement statement = null;
                String query = "INSERT INTO kickaj.accounts(username, password, role, name, email, shipping_address, billing_address) VALUES(?,?,?,?,?,?,?);";
               
                conn.setAutoCommit(false);
                statement = conn.prepareStatement(query);
                statement.setString(1, customer.getUsername());
                statement.setString(2, customer.getPassword());
                statement.setString(3, customer.getRole());
                statement.setString(4, customer.getName());
                statement.setString(5, customer.getEmail());
                statement.setString(6, customer.getShipping_address());
                statement.setString(7, customer.getBilling_address());
                statement.execute();                              
                conn.commit();               
            } catch (SQLException ex) {
                Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            Log log = new Log(id + "_Customer", 0,
                              "Add " + customer.getRole(),
                              "Added " + customer.getUsername() + " as " + customer.getRole() + ".", 
                              datetime);
            log.writeLog();
            
            return true;
        } return false;
    }

    private boolean checkIfExists(String username){
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM kickaj.accounts WHERE username = ?;";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rsList = statement.executeQuery();
            conn.commit();
            
            if(rsList.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
        } return false;
    }
}
