package liga.medical.personservice.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Illness {

    @NonNull
    @Id
    private long id;

    @NonNull
    private long medicalCardId;

    private long typeId;

    private String heaviness;

    @NonNull
    private Timestamp appearanceDttm;

    private Date recoveryDt;
}
