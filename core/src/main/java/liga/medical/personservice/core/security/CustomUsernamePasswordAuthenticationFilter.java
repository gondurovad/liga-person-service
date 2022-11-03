package liga.medical.personservice.core.security;

import liga.medical.personservice.core.mapping.LogMapper;
import liga.medical.personservice.dto.LogLoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

@Slf4j
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter  {

    private final LogMapper logMapper;

    public CustomUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager, LogMapper logMapper) {
        this.logMapper = logMapper;
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String logName = log.getName();
        Timestamp date = new Timestamp(System.currentTimeMillis());
        log.info("LogName: " + logName + ", Date: " + date + " User " + username + " try to login.");
        LogLoginDTO dto = LogLoginDTO.builder()
                .log(log.getName())
                .username(username)
                .date(date)
                .build();
        logMapper.logLogin(dto);

        return super.attemptAuthentication(request, response);
    }
}
