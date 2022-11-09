package liga.medical.personservice.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.common.dto.LogType;
import liga.medical.common.dto.RabbitMessageDTO;
import liga.medical.personservice.core.mapping.PersonMapper;
import liga.medical.personservice.core.mapping.SignalsMapper;
import liga.medical.personservice.core.model.Signals;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.After;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
@Slf4j
public class LoggingAdvice {

    //private final LoggingService loggingService; //from common

    private final ObjectMapper objectMapper;
    private final PersonMapper personMapper;
    private final SignalsMapper signalsMapper;

    public LoggingAdvice(ObjectMapper objectMapper, PersonMapper personMapper, SignalsMapper signalsMapper) {
        this.objectMapper = objectMapper;
        this.personMapper = personMapper;
        this.signalsMapper = signalsMapper;
    }

    @Pointcut(value = "execution(* liga.medical.personservice.core.controller.*.*(..))")
    public void controllerPointcut() {
    }

    @Pointcut("@annotation(liga.medical.personservice.core.annotations.DBLog)")
    public void dbLog() {

    }

    @After("controllerPointcut()")
    public void afterControllerLogger(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("LogName: " + log.getName() + ", Class: " + className + ", Method: " +
                 methodName + "()" + ", Date: " + new Date() + " User: " + auth.getName());
    }

    private void logMessage(LogType logType, String className, String methodName, Object[] args) {
        /*loggingService.logMessage(logType, SYSTEM_TYPE_ID,
                "Class: " + className + ", method: " + methodName + ", args: " + Arrays.toString(args));*/
        log.info("LogType: " + logType.toString() + " Class: " + className + ", method: " + methodName + ", args: " + Arrays.toString(args));
    }

    @Around("dbLog()")
    public Object dbLogger(ProceedingJoinPoint pjp) {
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();

        String message = (String)args[0];

        try {
            RabbitMessageDTO messageDto = objectMapper.readValue(message, RabbitMessageDTO.class);
            if (personMapper.getById(messageDto.getId()) == null) {
                logMessage(LogType.EXCEPTION, className, methodName, args);
            } else {
                Signals signal = new Signals();
                signal.setPersonDataId(messageDto.getId());
                signal.setDescription(messageDto.getDescription());
                signal.setType(messageDto.getType().toString());
                signalsMapper.createSignal(signal);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return obj;
    }
}