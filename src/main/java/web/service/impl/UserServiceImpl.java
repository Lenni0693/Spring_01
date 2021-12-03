package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userD;

    @Override
    public void addUser(User user){
        userD.save(user);
    }

    @Override
    public void deleteUser(long id){
        userD.deleteById(id);
    }

    @Override
    public List<User> listUser(){
        return  userD.findAll();
    }

    @Override
    public void updateUser(User user){
        userD.saveAndFlush(user);
    }

    @Override
    public User getUserByID(Long id) {
        return userD.findById(id).get();
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user =  userD.findByUsername(userName);
        return user;
    }

}
