package liga.medical.personservice.core.mapping;

import liga.medical.personservice.core.model.Illness;
import liga.medical.personservice.core.model.Role;
import liga.medical.personservice.core.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface UserMapper {

    @Select("select * from users where username = #{username}")
    User findByUsername(@Param("username") String username);

    @Insert("insert into users (id, username, password, status) " +
            "values (#{id}, #{username}, #{password}, #{status})")
    void saveUser(User user);

    @Insert("insert into user_role (user_id, role_id) " +
            "values (#{userId}, 2)")
    void assignUserRole(@Param("userId") long userId);

    @Insert("insert into user_role (user_id, role_id) " +
            "values (#{userId}, 1)")
    void assignAdminRole(@Param("userId") long userId);

    @Select("select * from role where id in (select role_id from user_role where user_id = #{userId})")
    Set<Role> getUserRoles(@Param("userId") long userId);
}