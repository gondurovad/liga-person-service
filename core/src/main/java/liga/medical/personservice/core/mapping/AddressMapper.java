package liga.medical.personservice.core.mapping;

import liga.medical.personservice.core.model.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Select("select * from address")
    List<Address> getAllAddresses();

    @Select("select * from address where id = #{id}")
    Address getById(Long id);

    @Update("update address set contact_id = #{contactId}, country_id = #{countryId}, city = #{city}, " +
            "index = #{index}, street = #{street}, building = #{building}, flat = #{flat} where id = #{id}")
    void updateAddress(Address address);

}
