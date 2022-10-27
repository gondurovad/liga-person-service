package liga.medical.personservice.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
@NoArgsConstructor
public class PersonData {

    @NonNull
    @Id
    private long id;

    @NonNull
    private String lastName;

    @NonNull
    private String firstName;

    @NonNull
    private Date birthDt;

    private long age;

    @NonNull
    private String sex;

    @NonNull
    private long contactId;

    @NonNull
    private long medicalCardId;

    private long parentId;
}
