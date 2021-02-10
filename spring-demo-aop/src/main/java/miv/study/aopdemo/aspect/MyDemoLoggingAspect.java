package miv.study.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyDemoLoggingAspect {

    @Before("miv.study.aopdemo.aspect.AopExpressions.excludeGettersAndSetters()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println(">> Executing @Before excluding getters/setters");
        // display the method signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + signature);
        // display the method arguments
        // get args
        Object[] args = joinPoint.getArgs();
        // loop through args
        for (Object arg : args) {
            System.out.println(arg);
        }
    }
}
