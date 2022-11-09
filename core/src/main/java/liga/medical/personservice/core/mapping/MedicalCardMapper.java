package liga.medical.personservice.core.mapping;

import liga.medical.personservice.core.model.MedicalCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicalCardMapper {

    @Select("select * from medical_card")
    List<MedicalCard> getAllMedCards();
}
