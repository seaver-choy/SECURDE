package object;

public class Transaction {
    private int transaction_id;
    private int account_id;
    private int product_id;
    private int quantity;
    private float total_price;
    
    //Fetch from DB
    public Transaction(int transaction_id, int account_id, int product_id, int quantity, float total_price) {
        this.transaction_id = transaction_id;
        this.account_id = account_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
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
