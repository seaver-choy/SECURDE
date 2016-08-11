package dao;

import object.Account;

public interface LoginDAO {
    public Account login(String username, String password);
    public void register(Account customer);
}
