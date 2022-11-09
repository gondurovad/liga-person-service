package liga.medical.personservice.core.mapping;

import liga.medical.personservice.core.model.PersonData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Select("select * from person_data")
    List<PersonData> getAllPersons();

    @Select("select * from person_data where id = #{id}")
    PersonData getById(Long id);
}
