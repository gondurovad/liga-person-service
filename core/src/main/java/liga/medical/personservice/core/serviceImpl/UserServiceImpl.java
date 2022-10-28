package liga.medical.personservice.core.serviceImpl;

import liga.medical.personservice.core.mapping.UserMapper;
import liga.medical.personservice.core.model.User;
import liga.medical.personservice.core.service.RoleService;
import liga.medical.personservice.core.service.UserService;
import liga.medical.personservice.dto.UserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static long uuid = 3;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    private final RoleService roleService;

    private final UserMapper userMapper;

    public UserServiceImpl(RoleService roleService, UserMapper userMapper) {
        this.roleService = roleService;
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(UserDTO dto) {
        User user = new User();
        user.setId(++uuid);
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setStatus("ACTIVE");
        userMapper.saveUser(user);
        if (dto.isAdmin()) {
            userMapper.assignAdminRole(user.getId());
            userMapper.assignUserRole(user.getId());
        } else userMapper.assignUserRole(user.getId());
    }

    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        if (user == null) return null;
        user.setRoles(userMapper.getUserRoles(user.getId()));
        return user;
    }
}