package liga.medical.personservice.core.mapping;

import liga.medical.personservice.core.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface RoleMapper {

    @Select("select * from role")
    Set<Role> getAllRoles();

    @Select("select * from role where name = #{name}")
    Role getRoleByName(@Param("name") String name);
}