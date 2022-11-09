package liga.medical.personservice.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Signals {

    @NonNull
    @Id
    private long id;

    @NonNull
    private long personDataId;

    private String description;

    @NonNull
    private String type;

}
