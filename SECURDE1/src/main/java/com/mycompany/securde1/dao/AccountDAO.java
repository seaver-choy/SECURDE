/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.securde1.dao;

import java.util.ArrayList;
import object.Account;

/**
 *
 * @author Seaver
 */
public interface AccountDAO {
    public ArrayList<Account> getAllCustomerAccounts();
    public Account getAccount(int account_id);
    public Account getAccount(String username);
}
