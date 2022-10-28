package liga.medical.personservice.core.serviceImpl;

import liga.medical.personservice.core.mapping.RoleMapper;
import liga.medical.personservice.core.model.Role;
import liga.medical.personservice.core.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public Set<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleMapper.getRoleByName(name);
    }
}