package liga.medical.personservice.core.mapping;

import liga.medical.personservice.core.model.PersonData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Select("select * from person_data")
    @Result(property = "lastName", column = "last_name")
    @Result(property = "firstName", column = "first_name")
    @Result(property = "birthDt", column = "birth_date")
    @Result(property = "contactId", column = "contact_id")
    @Result(property = "medicalCardId", column = "medical_card_id")
    @Result(property = "parentId", column = "parent_id")
    List<PersonData> getAllPersons();
}
