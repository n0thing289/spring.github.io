package service;

import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("securityAspect")
@Order(1)
public class SecurityAspect {
    //切面= 切点+通知
    @Before("execution(* service..*(..))")
    public void advice(){
        System.out.println("前置通知:...安全");
    }
}
