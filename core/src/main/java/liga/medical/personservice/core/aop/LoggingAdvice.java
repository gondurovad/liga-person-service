package liga.medical.personservice.core.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.After;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@Slf4j
public class LoggingAdvice {

    @Pointcut(value = "execution(* liga.medical.personservice.core.controller.*.*(..))")
    public void controllerPointcut() {
    }

    @After("controllerPointcut()")
    public void afterControllerLogger(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("LogName: " + log.getName() + ", Class: " + className + ", Method: " +
                 methodName + "()" + ", Date: " + new Date() + " User: " + auth.getName());
    }

    /*@After("execution(* org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler.onAuthenticationSuccess(..))")
    public void authenticated() {
        System.out.println("User " + SecurityContextHolder.getContext().getAuthentication().getName() + " successfully logged in.");
    }*/
}