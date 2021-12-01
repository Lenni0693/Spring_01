package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;


@Repository
public interface RoleDao extends JpaRepository<Role,Long>{

    @Query("SELECT r FROM Role r WHERE r.name = :name")
    Role getRoleByName(String name);
}
