package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user){
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(long id){
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user){
        entityManager.merge(user);
    }

    @Override
    public List<User> listUser(){
        return entityManager.createQuery("from User",User.class).getResultList();
    }

    @Override
    public User getUserByID(Long id){
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByUsername(String name) {
        User user = entityManager
                .createQuery("select u from User u where u.userName = :name", User.class)
                .setParameter("name", name)
                .getSingleResult();
        return user;
    }
}
