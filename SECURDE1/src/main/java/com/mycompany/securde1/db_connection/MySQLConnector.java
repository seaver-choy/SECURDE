package com.mycompany.securde1.db_connection;

import dao.ProductDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;
import model.ProductModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySQLConnector {
    
    private static String url;
    private static String dbName;
    private static String driver;
    private static String userName;
    private static String pass;
    private static Connection conn;
    private static DataSource dataSource;
    private static MySQLConnector mySQLConnector;
    
    public MySQLConnector(String url, String dbName, String driver, String userName, String pass){
        this.url = url;             //"jdbc:mysql://localhost:3306/"; 
        this.dbName = dbName;       //"constellation";
        this.driver = driver;       //"com.mysql.jdbc.Driver"; 
        this.userName = userName;   //"root"; 
        this.pass = pass;           //"1234";
    }
    
    public MySQLConnector(){
            
    }
    /*    
    public static Connection getConnection(){	 
        if(conn == null){
            try {
                
                Class.forName(driver).newInstance();
                conn = DriverManager.getConnection(url + dbName, userName, pass);
                System.out.println(conn);
                
                return conn;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	return conn; 
    }
    */
    
    
    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }
    
    public static Connection getConnection(){
        if(conn == null){
            try {               
                conn = dataSource.getConnection();
                ProductDAO prodDAO = new ProductModel();
                prodDAO.getAllProducts();
                
                return conn;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }
    public void executeStatement(String statement){
        Connection conn = getConnection();
	ResultSet res = null;
	
        try {
            Statement st = conn.createStatement();
            st.execute(statement);
            conn.close();
	} catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB error");
	}
    }
    
    public ResultSet executeQuery(String query) {
        ResultSet result = null;
        Connection conn = getConnection();
        
        try {
            Statement st = conn.createStatement();
            result = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
