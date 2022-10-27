package liga.medical.personservice.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Address {

    @NonNull
    @Id
    private long id;

    @NonNull
    private long contactId;

    @NonNull
    private long countryId;

    @NonNull
    private String city;

    private long index;

    @NonNull
    private String street;

    @NonNull
    private String building;

    private String flat;
}
