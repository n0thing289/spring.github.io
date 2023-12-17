package service1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAspect {
    @Around("execution(* service1..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        try{
            System.out.println("开启事务");
            //执行目标方法
            joinPoint.proceed();
            System.out.println("提交事务");
        }catch(Exception e){
            System.out.println("回滚事务");
        }
    }
}
