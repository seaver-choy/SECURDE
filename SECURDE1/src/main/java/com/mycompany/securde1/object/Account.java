package object;

public class Account {
    private int account_id;
    private String username;
    private String password;
    private String role;
    private String name;
    private String email;
    private String shipping_address;
    private String billing_address;
    
    //Fetch Admin account from DB
    public Account(int account_id, String username, String password, String role, String name, String email) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
    }
    
    //Fetch Customer from DB
    public Account(int account_id, String username, String password, String name, String email, String shipping_address, String billing_address) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
        this.role = "Customer";
        this.name = name;
        this.email = email;
        this.shipping_address = shipping_address;
        this.billing_address = billing_address;
    }
    
    //Add Admin to DB
    public Account(String username, String password, String role, String name, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
    }
    
    //Add Customer to DB
    public Account(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.role = "Customer";
        this.name = name;
        this.email = email;
    }
    
    //Add Customer with Addresses to DB
    public Account(String username, String password, String name, String email, String shipping_address, String billing_address) {
        this.username = username;
        this.password = password;
        this.role = "Customer";
        this.name = name;
        this.email = email;
        this.shipping_address = shipping_address;
        this.billing_address = billing_address;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }
}
