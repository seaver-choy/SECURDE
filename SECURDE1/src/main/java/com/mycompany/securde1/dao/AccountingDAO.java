package dao;

import java.util.ArrayList;
import object.TotalSales;

public interface AccountingDAO {
     public TotalSales getTotalSales();
     public ArrayList<TotalSales> getTotalPerCategory();
     public ArrayList<TotalSales> getTotalPerProduct();
}
