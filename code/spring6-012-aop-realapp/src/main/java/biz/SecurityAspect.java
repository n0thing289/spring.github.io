package biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component
@Aspect
public class SecurityAspect {
    @Pointcut("execution(* biz..save*(..))")
    public void savePointcut(){}

    @Pointcut("execution(* biz..delete*(..))")
    public void deletePointcut(){}

    @Pointcut("execution(* biz..update*(..))")
    public void updatePointcut(){}

    @Before("savePointcut() || deletePointcut() || updatePointcut()")
    public void beforeAdvice(JoinPoint joinPoint){
        //系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String nowTime = sdf.format(new Date());
        //输出日志信息
        System.out.println(nowTime + " zhangsan : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
}
