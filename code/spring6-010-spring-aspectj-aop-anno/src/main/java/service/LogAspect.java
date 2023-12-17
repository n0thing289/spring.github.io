package service;

import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面
 */
@Component("logAspect")
@Aspect //切面需要Aspect标注
@Order(3)
public class LogAspect {
    //定义通用的切点表达式
    @Pointcut("execution(* service..*(..))")
    public void genericPointcut(){
        //方法只是标记, 方法名任意, 跨类使用需要带完成包名}
    }
    //切面 = 通知 + 切点
    //通知就是增强.就是具体要编写的增加代码
    //通知以方法的形式出现
    //@Before标注的方法就是一个前置通知
    @Before("genericPointcut()")//要写切点表达式
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("前置通知");
        // 这个JoinPoint joinPoint，在Spring容器调用这个方法的时候自动传过来
        // 我们可以直接用。用这个JoinPoint joinPoint 于啥?
        // Signature signature = joinPoint.getSignature(); 获取目标方法的签名。
        // 通过方法的签名可以获取到一个方法的具体信息。
        // 获取目标方法的方法名。
        System.out.println("目标方法的方法名:"+ joinPoint.getSignature().getName());
    }

    //后置通知
    @AfterReturning("genericPointcut()")
    public void afterReturningAdvice(){
        System.out.println("后置通知");
    }

    //环绕通知(在前置通知之前,在后置通知之后)
    @Around("genericPointcut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        //前面的代码
        System.out.println("前环绕");
        //目标方法
        joinPoint.proceed();
        //后面的代码
        System.out.println("后环绕");
    }

    //异常通知
    @AfterThrowing("genericPointcut()")
    public void afterThrowing(){
        System.out.println("异常通知");
    }

    //最终通知(在finally中语句块的通知)
    @After("genericPointcut()")
    public void afterAdvice(){
        System.out.println("最终通知");
    }


}
