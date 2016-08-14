package test;

import db_connection.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Account;
import object.Log;

public class TestAdminModel{
    public static ArrayList<Account> getAllAccounts(){
        ArrayList<Account> objectList = new ArrayList<Account>();
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM accounts WHERE role != 'Customer' AND role != 'Administrator';";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            ResultSet rsList = statement.executeQuery();
            conn.commit();
            
            while(rsList.next()) {
                objectList.add(new Account(rsList.getInt("account_id"),
                                 rsList.getString("username"),
                                 rsList.getString("password"),
                                 rsList.getString("role"),
                                 rsList.getString("name"),
                                 rsList.getString("email")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestAdminModel.class.getName()).log(Level.SEVERE, null, ex);
        } return objectList;
    }

    public static Account getAccount(int account_id){
        Account account = null;
        
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM accounts WHERE account_id = ? AND role != 'Customer' AND role != 'Administrator';";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setInt(1, account_id);
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
            Logger.getLogger(TestAdminModel.class.getName()).log(Level.SEVERE, null, ex);
        } return account;
    }

    public static boolean addAccount(Account account){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SS");
        DateFormat idFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss-SS");
        String datetime = dateFormat.format(new Date());
        String id = idFormat.format(new Date());
        
        if(!checkIfExists(account)){
            try {
                Connection conn = MySQLConnector.getConnection();
                PreparedStatement statement = null;
                String query = "INSERT INTO accounts(username, password, role, name, email, shipping_address, billing_address) VALUES(?,?,?,?,?, NULL, NULL);";
               
                conn.setAutoCommit(false);
                statement = conn.prepareStatement(query);
                statement.setString(1, account.getUsername());
                statement.setString(2, account.getPassword());
                statement.setString(3, account.getRole());
                statement.setString(4, account.getName());
                statement.setString(5, account.getEmail());
                statement.execute();                              
                conn.commit();               
            } catch (SQLException ex) {
                Logger.getLogger(TestAdminModel.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            Log log = new Log(id + "_Admin", 1,
                              "Add " + account.getRole(),
                              "Added " + account.getUsername() + " as " + account.getRole() + ".", 
                              datetime);
            log.writeLog();
            
            return true;
        } return false;
    }

    public static void deleteAccount(int account_id){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SS");
        DateFormat idFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss-SS");
        String datetime = dateFormat.format(new Date());
        String id = idFormat.format(new Date());
        
        try{
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "DELETE FROM accounts WHERE account_id = ?;";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setInt(1, account_id);
            statement.execute();
            conn.commit(); 
        } catch (SQLException ex) {
            Logger.getLogger(TestAdminModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Log log = new Log(id + "_Admin", 1,
                          "Delete " + account_id,
                          "Deleted " + account_id + " from the administrators list.", 
                          datetime);
        log.writeLog();
    }

    private static boolean checkIfExists(Account account){
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM accounts WHERE username = ? AND role != 'Customer' AND role != 'Administrator';";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setString(1, account.getUsername());
            ResultSet rsList = statement.executeQuery();
            conn.commit();
            
            if(rsList.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestAdminModel.class.getName()).log(Level.SEVERE, null, ex);
        } return false;
    }
}
