package dao;

import java.util.ArrayList;
import object.Account;
import object.Product;
import object.Review;

public interface CustomerDAO {
    public boolean addCustomer(Account account);
    public void updateCustomer(int customer_id, Account account);
    public ArrayList<Product> getAllProducts();
    public ArrayList<Review> getProductReviews(int product_id);
    public Product getProduct(int product_id);
    public boolean buyProduct(Account account, Product product, int quantity, boolean validCredit);
    public boolean reviewProduct(Account account, Product product, String title, String details); 
}
