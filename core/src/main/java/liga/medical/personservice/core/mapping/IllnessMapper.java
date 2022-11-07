package liga.medical.personservice.core.mapping;

import liga.medical.personservice.core.model.Illness;
import liga.medical.personservice.core.model.MedicalCard;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IllnessMapper {

    @Select("select * from illness")
    @Result(property = "medicalCardId", column = "medical_card_id")
    @Result(property = "typeId", column = "type_id")
    @Result(property = "appearanceDttm", column = "appearance_dttm")
    @Result(property = "recoveryDt", column = "recovery_dt")
    List<Illness> getAllIllnesses();

    @Insert("insert into illness (id, medical_card_id, type_id, heaviness, " +
            "appearance_dttm, recovery_dt) values (#{id}, #{medicalCardId}, #{typeId}, " +
            "#{heaviness}, #{appearanceDttm}, #{recoveryDt})")
    void createIllness(Illness illness);

    @Select("select * from medical_card where id = #{medId}")
    MedicalCard findCardById(@Param("medId") long medId);

    @Insert("insert into illness (medical_card_id, type_id, heaviness, " +
            "appearance_dttm, recovery_dt) values (#{medicalCardId}, #{typeId}, " +
            "#{heaviness}, #{appearanceDttm}, #{recoveryDt})")
    @Options(useGeneratedKeys=true, keyProperty = "id")
    void insertIllness(Illness illness);
}
