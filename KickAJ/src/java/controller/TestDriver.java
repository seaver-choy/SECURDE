package controller;

import db_connection.File;
import db_connection.TXTFile;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import test.*;
import object.Account;
import object.Product;
import object.TotalSales;

public class TestDriver {
    public static void main(String[] args) {
        File file = new TXTFile("src/db_connection/config.txt");
        
        if(file.getConnector().getConnection() != null){
            System.out.println("GUMANA AMPUTA");
                       
            //testAdmin();    /*Admin Functionalities*/
            //testProdMngr(); /*Product Manager Functionalities*/
            //testAcctMngr(); /*Accounting Manager Functionalities*/
            testCustomer();   /*Customer Functionalities*/
        }else{
            System.out.println("AYAW GUMANA AMPUTA");
            JOptionPane.showMessageDialog(null, "Error connecting to MySQL!", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void testAdmin(){       
        Account prodMan = new Account("productMan", "1234", "Product Manager", "Yaweh", "product.manager@gmail.com");
        Account acctMan = new Account("accountMan", "1234", "Accounting Manager", "Messiah", "accounting.manager@gmail.com");
        Account cust = new Account("pedroSan", "1234", "Customer", "Pedro San", "xxPussySlayerxx@gmail.com");
        TestAdminModel.addAccount(prodMan);
        TestAdminModel.addAccount(acctMan);
        TestAdminModel.addAccount(cust);
        //TestAdminModel.deleteAccount(4);
    }
    
    public static void testProdMngr(){
        Product prod1 = new Product("Tsinelas", "Slippers", "kewl slippers", (float) 10);
        Product prod2 = new Product("Sandalias", "Sandals", "kewl sandals", (float) 15);           
        Product prod3 = new Product("Sapatos", "Shoes", "kewl shoes", (float) 20);
        Product prod4 = new Product("Bota", "Boots", "kewl boots", (float) 25);
        Product prod5 = new Product("Crocs", "Sandals", "shit sandals", (float) 0.01); 
        Product newProd5 = new Product("Crocs", "Sandals", "bat ka na naman bibili nito", (float) 0.01); 
        
        TestProductModel.addProduct(prod1); 
        TestProductModel.addProduct(prod2); 
        TestProductModel.addProduct(prod3); 
        TestProductModel.addProduct(prod4); 
        TestProductModel.addProduct(prod5); 
        //TestProductModel.updateProduct(5, newProd5); 
        //TestProductModel.deleteProduct(5);
    }
    
    public static void testAcctMngr(){
        TotalSales total = TestAccountingModel.getTotalSales();
        System.out.println("Quantity: " + total.getQuantity() + " - Total: " + total.getTotal_price());
        
        ArrayList<TotalSales> category = TestAccountingModel.getTotalPerCategory();
        for(int i = 0; i < category.size(); i++)
            System.out.println("Category: " + category.get(i).getCategory() + " - Quantity: " + category.get(i).getQuantity() + " - Total: " + category.get(i).getTotal_price());
        
        ArrayList<TotalSales> product = TestAccountingModel.getTotalPerProduct();
        for(int i = 0; i < product.size(); i++)
            System.out.println("Product: " + product.get(i).getName() + " - Quantity: " + product.get(i).getQuantity() + " - Total: " + product.get(i).getTotal_price());
    }
    
    public static void testCustomer(){
        Account cust1 = new Account("saintPeter", "1234", "Saint Peter", "xxCuntDestroyerxx@gmail.com");
        //TestCustomerModel.addCustomer(cust1);
        
        Account cust2 = new Account("boyHentai", "6969", "Angelo Matias", "Dix4Lunch@gmail.com", "sa bahay", "kay mama");
        //TestCustomerModel.updateCustomer(5, cust2);
        
        /*Kunyari galing DB yung customer at prod kaya may ID*/
        Account cust3 = TestLoginModel.getAccount("boyHentai","6969");
        Product prod1 = TestCustomerModel.getProduct(1);
        Product prod2 = TestCustomerModel.getProduct(2);
        Product prod3 = TestCustomerModel.getProduct(3);
        Product prod4 = TestCustomerModel.getProduct(4);
        Product prod5 = TestCustomerModel.getProduct(6);
        
        //TestCustomerModel.buyProduct(cust3, prod1, 10, true);
        //TestCustomerModel.buyProduct(cust3, prod2, 22, true);
        //TestCustomerModel.buyProduct(cust3, prod3, 1, true);
        //TestCustomerModel.buyProduct(cust3, prod4, 12, true);
        //TestCustomerModel.buyProduct(cust3, prod5, 43, true);
        //TestCustomerModel.buyProduct(cust3, prod2, 15, true);
        //TestCustomerModel.buyProduct(cust3, prod3, 69, true);
        TestCustomerModel.buyProduct(cust3, prod1,100, true);
        //TestCustomerModel.reviewProduct(cust3, prod5, "Crox wid Sox", "Ultimate chix magnet, guarantee laglag panty");
    }
}
