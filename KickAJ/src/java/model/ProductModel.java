package model;

import dao.ProductDAO;
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
import object.Log;
import object.Product;

public class ProductModel implements ProductDAO{
    @Override
    public ArrayList<Product> getAllProducts(){
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
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        } return objectList;
    }
    
    @Override
    public Product getProduct(int product_id){
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
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        } return product;
    }
    
    @Override
    public boolean addProduct(Product product){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SS");
        DateFormat idFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss-SS");
        String datetime = dateFormat.format(new Date());
        String id = idFormat.format(new Date());

        if(!checkIfExists(product)){
            try{
                Connection conn = MySQLConnector.getConnection();
                PreparedStatement statement = null;
                String query = "INSERT INTO products(name, category, details, price) VALUES(?,?,?,?);";

                conn.setAutoCommit(false);
                statement = conn.prepareStatement(query);
                statement.setString(1, product.getName());
                statement.setString(2, product.getCategory());
                statement.setString(3, product.getDetails());
                statement.setFloat(4, product.getPrice());
                statement.execute();
                conn.commit();
            } catch (SQLException ex) {
                Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
            }

            Log log = new Log(id + "_ProdMngr", 2,
                              "Add Product",
                              "Added " + product.getName() + " to the products list.", 
                              datetime);
            log.writeLog();
            
            return true;
        } return false;
    }
    
    @Override
    public void updateProduct(int product_id, Product product){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SS");
        DateFormat idFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss-SS");
        String datetime = dateFormat.format(new Date());
        String id = idFormat.format(new Date());
        
        try{
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "UPDATE products SET name = ?, category = ?, details = ?, price = ? WHERE product_id = ?";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setString(1, product.getName());
            statement.setString(2, product.getCategory());
            statement.setString(3, product.getDetails());
            statement.setFloat(4, product.getPrice());
            statement.setInt(5, product_id);
            statement.execute();
            conn.commit();           
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Log log = new Log(id + "_ProdMngr", 2,
                          "Update Product",
                          "Updated product #" + product_id + "'s product details.", 
                          datetime);
        log.writeLog();
    }
    
    @Override
    public void deleteProduct(int product_id){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SS");
        DateFormat idFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss-SS");
        String datetime = dateFormat.format(new Date());
        String id = idFormat.format(new Date());
        
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "DELETE FROM products WHERE product_id = ?;";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setInt(1, product_id);
            statement.execute();
            conn.commit();          
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Log log = new Log(id + "_ProdMngr", 2,
                          "Delete " + product_id,
                          "Deleted " + product_id + " from the product list.", 
                          datetime);
        log.writeLog();
    }
    
    private boolean checkIfExists(Product product){
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT * FROM products WHERE name = ?;";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            statement.setString(1, product.getName());
            ResultSet rsList = statement.executeQuery();
            conn.commit();
            
            if(rsList.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        } return false;
    }
}
