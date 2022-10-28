package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.User;
import liga.medical.personservice.dto.UserDTO;

public interface UserService {

    void saveUser(UserDTO dto);

    User findByUsername(String username);
}