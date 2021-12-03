package web.service;

import web.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<Role> getListRole();

    Role getRoleByName(String roleName);

    Set<Role> getSetRoles(String... roles);

}
