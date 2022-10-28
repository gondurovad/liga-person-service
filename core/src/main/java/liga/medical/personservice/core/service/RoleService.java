package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.Role;

import java.util.Set;

public interface RoleService {

    Set<Role> getAllRoles();

    Role getRoleByName(String name);
}