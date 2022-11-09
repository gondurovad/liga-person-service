package liga.medical.personservice.core.mapping;

import liga.medical.personservice.core.model.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContacMapper {

    @Select("select * from contact")
    List<Contact> getAllContacts();

    @Select("select * from contact where id in (select contact_id from person_data where id = #{personId})")
    Contact getContactByPersonId(@Param("personId") long personId);

    @Update("update contact set phone_number = #{phoneNumber}, email = #{email}, profile_link = #{profileLink} where id = #{id}")
    void updateContact(Contact contact);
}
