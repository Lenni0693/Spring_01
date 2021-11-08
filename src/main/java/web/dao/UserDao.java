package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);

    public void deleteUser(long id);

    List<User> listUser();

    public void updateUser(User user);

    public User getUserByID(Long id);

    public User getUserByUsername(String name);
}

