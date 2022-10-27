package liga.medical.personservice.core.mapping;

import liga.medical.personservice.core.model.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Select("select * from address")
    @Result(property = "countryId", column = "country_id")
    @Result(property = "contactId", column = "contact_id")
    List<Address> getAllAddresses();
}
