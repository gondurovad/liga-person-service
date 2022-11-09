package liga.medical.personservice.core.mapping;

import liga.medical.personservice.core.model.Illness;
import liga.medical.personservice.core.model.MedicalCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

@Mapper
public interface IllnessMapper {

    @Select("select * from illness")
    List<Illness> getAllIllnesses();

    @Insert("insert into illness (id, medical_card_id, type_id, heaviness, " +
            "appearance_dttm, recovery_dt) values (#{id}, #{medicalCardId}, #{typeId}, " +
            "#{heaviness}, #{appearanceDttm}, #{recoveryDt})")
    void createIllness(Illness illness);

    @Select("select count(*) from illness")
    int count();

    @Select("select * from medical_card where id = #{medId}")
    MedicalCard findCardById(@Param("medId") long medId);
}
