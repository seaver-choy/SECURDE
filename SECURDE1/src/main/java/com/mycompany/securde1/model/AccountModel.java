/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.securde1.model;

import com.mycompany.securde1.dao.AccountDAO;
import com.mycompany.securde1.db_connection.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Account;

/**
 *
 * @author Seaver
 */
public class AccountModel implements AccountDAO{
    
    @Override
    public ArrayList<Account> getAllCustomerAccounts(){
        ArrayList<Account> objectList = new ArrayList<Account>();
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM kickaj.accounts WHERE role == 'ROLE_CUST';";
            
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
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
        } return objectList;
    }
    
    @Override
    public Account getAccount(int account_id){
        Account account = null;
        
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM kickaj.accounts WHERE account_id = ?;";
            
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
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
        } return account;
    }
    
    @Override
    public Account getAccount(String username){
        Account account = null;
        
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
                account = new Account(rsList.getInt("account_id"),
                                 rsList.getString("username"),
                                 rsList.getString("password"),
                                 rsList.getString("role"),
                                 rsList.getString("name"),
                                 rsList.getString("email"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
        } return account;
    }
}
