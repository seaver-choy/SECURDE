package object;

public class Product {
    private int product_id;
    private String name;
    private String category;
    private String details;
    private float price;
    private String img_name;
    
    //Fetch from DB
    public Product(int product_id, String name, String category, String details, float price, String img_name) {
        this.product_id = product_id;
        this.name = name;
        this.category = category;
        this.details = details;
        this.price = price;
        this.img_name = img_name;
    }
    
    //Add to DB
    public Product(String name, String category, String details, float price) {
        this.name = name;
        this.category = category;
        this.details = details;
        this.price = price;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }
    
    
    
}
