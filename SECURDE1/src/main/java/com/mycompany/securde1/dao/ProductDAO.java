package dao;

import java.util.ArrayList;
import object.Product;

public interface ProductDAO {
    public ArrayList<Product> getAllProducts();
    public Product getProduct(int product_id);
    public boolean addProduct(Product product);
    public void updateProduct(int product_id, Product product);
    public void deleteProduct(int product_id);
}
