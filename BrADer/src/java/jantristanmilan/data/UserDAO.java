package jantristanmilan.data;

public interface UserDAO {

     void create(User user);

     User get(String username);
}
