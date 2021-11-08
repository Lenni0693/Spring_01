package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDapImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleByName(String name){
        Role role =  entityManager
                .createQuery("from Role where role = :name", Role.class)
                .setParameter("name", name)
                .getSingleResult();
        return role;
    }

    @Override
    public List<Role>getListRole(){
        return entityManager.createQuery("from Role",Role.class).getResultList();
    }


}
