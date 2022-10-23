package liga.medical.personservice.core.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
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

  private java.sql.Date recoveryDt;
}
