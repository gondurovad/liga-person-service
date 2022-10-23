package liga.medical.personservice.core.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
public class Contact {

  @NonNull
  @Id
  private long id;

  @NonNull
  private String phoneNumber;

  private String email;

  private String profileLink;
}
