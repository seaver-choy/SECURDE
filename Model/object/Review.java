package object;

public class Review {
    private int review_id;
    private int account_id;
    private int product_id;    
    private String title;
    private String details;
    private String time_stamp;
    
    //Fetch from DB
    public Review(int review_id, int account_id, int product_id, String title, String details, String time_stamp) {
        this.review_id = review_id;
        this.account_id = account_id;
        this.product_id = product_id;
        this.title = title;
        this.details = details;
        this.time_stamp = time_stamp;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    } 
}
