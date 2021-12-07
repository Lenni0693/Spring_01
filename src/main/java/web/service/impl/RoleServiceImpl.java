package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.model.Role;
import web.service.RoleService;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getRoleByName(String nameRole){
        return roleDao.getRoleByName(nameRole);
    }

    @Override
    public List<Role> getListRole(){
        return roleDao.findAll();
    }

    @Override
    public Set<Role> getSetRoles(String... roles){
        return roleDao.getSetRoles(roles);
    }
}
