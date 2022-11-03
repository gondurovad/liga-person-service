package liga.medical.personservice.core.mapping;

import liga.medical.personservice.dto.LogLoginDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {

    @Insert("INSERT INTO log_login VALUES (#{log}, #{username}, #{date});")
    void logLogin(LogLoginDTO logLoginDTO);
}
