package liga.medical.personservice.core.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Role implements GrantedAuthority {

    @NonNull
    @Id
    private long id;

    @NonNull
    private String name;

    @Override
    public String getAuthority() {
      return getName();
    }
}
