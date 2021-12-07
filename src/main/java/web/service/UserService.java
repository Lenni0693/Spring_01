package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    public void addUser(User user);

    public void deleteUser(long id);

    List<User> listUser();

    public void updateUser(User user);

    public User getUserByID(Long id);

}

