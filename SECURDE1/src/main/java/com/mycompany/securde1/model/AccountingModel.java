package com.mycompany.securde1.model;

import dao.AccountingDAO;
import com.mycompany.securde1.db_connection.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.TotalSales;

public class AccountingModel implements AccountingDAO{
    @Override
    public TotalSales getTotalSales(){     
        TotalSales total = null;
        int quantity = 0;
        float sum = 0;
        
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT SUM(quantity) AS 'quantity', SUM(total_price) AS 'total_price' FROM kickaj.transactions;";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            ResultSet rsList = statement.executeQuery();
            conn.commit();
            
            while(rsList.next()) {
                quantity += rsList.getInt("quantity");
                sum += rsList.getFloat("total_price");
            }
            
            total = new TotalSales(quantity, sum);
        } catch (SQLException ex) {
            Logger.getLogger(AccountingModel.class.getName()).log(Level.SEVERE, null, ex);
        } return total;
    }
    
    @Override
    public ArrayList<TotalSales> getTotalPerCategory(){     
        ArrayList<TotalSales> objectList = new ArrayList<TotalSales>();

        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT P.category, SUM(T.quantity) AS 'quantity', SUM(total_price) AS 'total_price'\n" +
                            "FROM kickaj.transactions T, products P\n" +
                            "WHERE P.product_id = T.product_id\n" +
                            "GROUP BY P.category;";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            ResultSet rsList = statement.executeQuery();
            conn.commit();
            
            while(rsList.next()) {
                objectList.add(new TotalSales(rsList.getString("category"),
                                                rsList.getInt("quantity"),
                                                rsList.getFloat("total_price")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountingModel.class.getName()).log(Level.SEVERE, null, ex);
        } return objectList;
    }
    
    @Override
    public ArrayList<TotalSales> getTotalPerProduct(){     
        ArrayList<TotalSales> objectList = new ArrayList<TotalSales>();

        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement statement = null;
            String query = "SELECT P.category, P.product_id, P.name,\n" +
                            "IFNULL(SUM(T.quantity), 0) AS'quantity',\n" +
                            "IFNULL(SUM(total_price), 0) AS 'total_price'\n" +
                            "FROM kickaj.products P\n" +
                            "LEFT JOIN kickaj.transactions T ON P.product_id = T.product_id\n" +
                            "GROUP BY P.category, P.category, P.product_id, P.name;";
            
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(query);
            ResultSet rsList = statement.executeQuery();
            conn.commit();
            
            while(rsList.next()) {
                objectList.add(new TotalSales(rsList.getString("category"),
                                                rsList.getInt("product_id"),
                                                rsList.getString("name"),
                                                rsList.getInt("quantity"),
                                                rsList.getFloat("total_price")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountingModel.class.getName()).log(Level.SEVERE, null, ex);
        } return objectList;
    }
}
