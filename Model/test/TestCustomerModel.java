package test;

import db_connection.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Account;
import object.Log;
import object.Product;
import object.Review;

public class TestCustomerModel {
    public static boolean addCustomer(Account customer){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SS");
        DateFormat idFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss-SS");
        String datetime = dateFormat.format(new Date());
        String id = idFormat.format(new Date());
        
        if(!checkIfExists(customer)){
            try {
                Connection conn = MySQLConnector.getConnection();
                PreparedStatement statement = null;
                String query = "INSERT INTO accounts(username, password, role, name, email, shipping_address, billing_address) VALUES(?,?,?,?,?,?,?);";
               
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
                Logger.getLogger(TestCustomerModel.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            Log log = new Log(id + "_Customer", 0,
                              "Add " + customer.getRole(),
                              "Added " + customer.getUsername() + " as " + customer.getRole() + ".", 
                              datetime);
            log.writeLog();
            
            return true;
        } return false;
    }
    
    public static Account getCustomer(String username, String password){
        Account customer = null;
        
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM accounts WHERE username = ? AND password = ? AND role = 'Customer';";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rsList = statement.executeQuery();
            conn.commit();
            
            if(rsList.next()) {
                customer = new Account(rsList.getInt("account_id"),
                                 rsList.getString("username"),
                                 rsList.getString("password"),
                                 rsList.getString("name"),
                                 rsList.getString("email"),
                                 rsList.getString("shipping_address"),
                                 rsList.getString("billing_address"));    
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestCustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        } return customer;
    }
    
    public static void updateCustomer(int customer_id, Account customer){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SS");
        DateFormat idFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss-SS");
        String datetime = dateFormat.format(new Date());
        String id = idFormat.format(new Date());
        
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "UPDATE accounts SET username = ?, password = ?, name = ?, email = ?, shipping_address = ?, billing_address = ? WHERE account_id = ?;";
               
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getName());
            statement.setString(4, customer.getEmail());
            statement.setString(5, customer.getShipping_address());
            statement.setString(6, customer.getBilling_address());
            statement.setInt(7, customer_id);
            statement.execute();                              
            conn.commit();               
        } catch (SQLException ex) {
            Logger.getLogger(TestCustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
        Log log = new Log(id + "_Customer", 0,
                          "Update Customer Profile",
                          "Updated " + customer.getUsername() + "'s profile details.", 
                          datetime);
        log.writeLog();
    }
    
    public static ArrayList<Product> getAllProducts(){
        ArrayList<Product> objectList = new ArrayList<Product>();
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM products;";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            ResultSet rsList = statement.executeQuery();
            conn.commit();
            
            while(rsList.next()) {
                objectList.add(new Product(rsList.getInt("product_id"),
                                 rsList.getString("name"),
                                 rsList.getString("category"),
                                 rsList.getString("details"),
                                 rsList.getFloat("price")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestCustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        } return objectList;
    }
    
    public static ArrayList<Review> getProductReviews(int product_id){
        ArrayList<Review> objectList = new ArrayList<Review>();
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM reviews WHERE product_id = ?;";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setInt(1, product_id);
            ResultSet rsList = statement.executeQuery();
            conn.commit();
            
            while(rsList.next()) {
                objectList.add(new Review(rsList.getInt("review_id"),
                                 rsList.getInt("account_id"),
                                 rsList.getInt("product_id"),
                                 rsList.getString("title"),
                                 rsList.getString("details"),
                                 rsList.getString("time_stamp")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestCustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        } return objectList;
    }
    
    public static Product getProduct(int product_id){
        Product product = null;
        
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM products WHERE product_id = ?;";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setInt(1, product_id);
            ResultSet rsList = statement.executeQuery();
            conn.commit();
           
            if(rsList.next()) {
                product = new Product(rsList.getInt("product_id"),
                                 rsList.getString("name"),
                                 rsList.getString("category"),
                                 rsList.getString("details"),
                                 rsList.getFloat("price"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestCustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        } return product;
    }
    
    public static boolean reviewProduct(Account customer, Product product, String title, String details){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SS");
        DateFormat idFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss-SS");
        String datetime = dateFormat.format(new Date());
        String id = idFormat.format(new Date());
        
        if(checkIfBought(customer, product)){
            try {
                Connection conn = MySQLConnector.getConnection();
                PreparedStatement statement = null;
                String query = "INSERT INTO reviews(account_id, product_id, title, details, time_stamp) VALUES(?,?,?,?,?);";
               
                conn.setAutoCommit(false);
                statement = conn.prepareStatement(query);
                statement.setInt(1, customer.getAccount_id());
                statement.setInt(2, product.getProduct_id());
                statement.setString(3, title);
                statement.setString(4, details);
                statement.setString(5, datetime);
                statement.execute();                              
                conn.commit();               
            } catch (SQLException ex) {
                Logger.getLogger(TestAdminModel.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            Log log = new Log(id + "_Customer-" + customer.getAccount_id(), customer.getAccount_id(),
                              "Review Product",
                              customer.getUsername() + " reviewed " + product.getName() + ".", 
                              datetime);
            log.writeLog();
            
            return true;
        } return false;
    }
    
    public static boolean buyProduct(Account customer, Product product, int quantity, boolean validCredit){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SS");
        DateFormat idFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss-SS");
        String datetime = dateFormat.format(new Date());
        String id = idFormat.format(new Date());
        
        if(validCredit){
            try {
                Connection conn = MySQLConnector.getConnection();
                PreparedStatement statement = null;
                String query = "INSERT INTO transactions(account_id, product_id, quantity, total_price, time_stamp) VALUES(?,?,?,?,?);";
               
                conn.setAutoCommit(false);
                statement = conn.prepareStatement(query);
                statement.setInt(1, customer.getAccount_id());
                statement.setInt(2, product.getProduct_id());
                statement.setInt(3, quantity);
                statement.setFloat(4, product.getPrice() * quantity);
                statement.setString(5, datetime);
                statement.execute();                              
                conn.commit();               
            } catch (SQLException ex) {
                Logger.getLogger(TestAdminModel.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            Log log = new Log(id + "_Customer-" + customer.getAccount_id(), customer.getAccount_id(),
                              "Buy Product",
                              customer.getUsername() + " bought " + product.getName() + " (x" + quantity + ").", 
                              datetime);
            log.writeLog();
            
            return true;
        } return false;
    }
    
    private static boolean checkIfBought(Account customer, Product product){
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM transactions WHERE account_id = ? AND product_id = ?;";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setInt(1, customer.getAccount_id());
            statement.setInt(2, product.getProduct_id());
            ResultSet rsList = statement.executeQuery();
            conn.commit();
            
            if(rsList.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestCustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        } return false;
    }
    
    private static boolean checkIfExists(Account customer){
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM accounts WHERE username = ? OR email = ? AND role = 'Customer';";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getEmail());
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
