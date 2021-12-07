package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.model.User;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(String username);



}
