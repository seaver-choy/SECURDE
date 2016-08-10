package dao;

import object.Account;

public interface LoginDAO {
    public Account getAccount(String username, String password);
}
