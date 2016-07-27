package jantristanmilan.data;

import jantristanmilan.utils.DatabaseUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdvertisementDAO implements AdvertisementDAO {
    private static Connection dbConnection =
            DatabaseUtilities.getConnection("ptf_brad");

    public List<Advertisement> getAll() {
        List<Advertisement> advertisements = new ArrayList<Advertisement>();

        try {
            String sql = "SELECT * FROM advertisements";
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                Advertisement ad = new Advertisement();
                ad.setTitle(rs.getString("title"));
                ad.setType(AdvertisementType.valueOf(rs.getString("type")));
                ad.setNumPortions(rs.getInt("num_portions"));
                ad.setPortionCost(rs.getFloat("portion_cost"));
                ad.setPortionSize(rs.getFloat("portion_size"));
                advertisements.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return advertisements;
    }

    public Advertisement get(int id) {
        Advertisement ad = null;

        try {
            String sql = "SELECT * FROM advertisements WHERE id = ?";
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                ad = new Advertisement();
                ad.setTitle(rs.getString("title"));
                ad.setType(AdvertisementType.valueOf(rs.getString("type")));
                ad.setNumPortions(rs.getInt("num_portions"));
                ad.setPortionCost(rs.getFloat("portion_cost"));
                ad.setPortionSize(rs.getFloat("portion_size"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ad;
    }
}
