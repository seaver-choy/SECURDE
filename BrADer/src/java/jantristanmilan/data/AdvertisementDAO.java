package jantristanmilan.data;

import java.util.List;

public interface AdvertisementDAO {

    List<Advertisement> getAll();

    Advertisement get(int id);
}
