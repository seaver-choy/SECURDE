package object;

import java.util.logging.Logger;

public class TotalSales {
    private String category;
    private int product_id;
    private String name;
    private int quantity;
    private float total_price;
    
    //Get total sales
    public TotalSales(int quantity, float total_price) {
        this.quantity = quantity;
        this.total_price = total_price;
    }
        
    //Get total by category
    public TotalSales(String category, int quantity, float total_price) {
        this.category = category;
        this.quantity = quantity;
        this.total_price = total_price;
    }
    
    //Get total by product
    public TotalSales(String category, int product_id, String name, int quantity, float total_price) {
        this.category = category;
        this.product_id = product_id;
        this.name = name;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    } 
}
