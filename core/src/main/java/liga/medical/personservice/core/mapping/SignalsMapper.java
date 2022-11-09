package liga.medical.personservice.core.mapping;

import liga.medical.personservice.core.model.Signals;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignalsMapper {
    @Insert("insert into signals (person_data_id, description, type) " +
            "values (#{personDataId}, #{description}, #{type})")
    void createSignal(Signals signal);
}
