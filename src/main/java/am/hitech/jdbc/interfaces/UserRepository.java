package am.hitech.jdbc.interfaces;

import am.hitech.jdbc.model.User;

import java.util.List;

public interface UserRepository {
    User getById(int id);
    User getByUsername(String username);
    int creatUserV2(User user);
    int updateUser(User user);
    int deleteUser(User user);
    User getbyPassToken(String pass);
    int updateUserPass(User user);
    List<User> getByName(String name);
    public List<User> getByNameSearch(String name, String userName);
    List<User> getAll();


}
