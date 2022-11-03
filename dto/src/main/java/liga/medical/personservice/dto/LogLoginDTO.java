package liga.medical.personservice.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder(toBuilder = true)
@Data
public class LogLoginDTO {

    String log;

    String username;

    Timestamp date;
}
