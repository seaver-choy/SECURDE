package dao;

import java.util.ArrayList;
import object.Account;

public interface AdminDAO {
    public ArrayList<Account> getAllAccounts();
    public Account getAccount(int account_id);
    public boolean addAccount(Account account);
    public void deleteAccount(int account_id);
}
