package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDaoImpl userD;


    @Override
    public void addUser(User user){
        userD.addUser(user);
    }
    @Override
    public void deleteUser(long id){
        userD.deleteUser(id);
    }

    @Override
    public List<User> listUser(){
        return  userD.listUser();
    }

    @Override
    public void updateUser(User user){
        userD.updateUser(user);
    }

    @Override
    public User getUserByID(Long id){
        return userD.getUserByID(id);
    }

}
