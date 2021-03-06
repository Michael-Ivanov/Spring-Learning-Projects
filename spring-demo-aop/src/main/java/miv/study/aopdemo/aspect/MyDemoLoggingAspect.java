package miv.study.aopdemo.aspect;

import miv.study.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @AfterReturning(
            pointcut = "miv.study.aopdemo.aspect.AopExpressions.afterThrowingPointcut()",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println(">>>> Executing @AfterReturning on method: " + method);

        // post-process the results
        if (!result.isEmpty()) {
            result.get(0).setName("Daffy Duck");
        }

        // print out the results
        System.out.println(">>>> result is: " + result);
    }

    @AfterThrowing(
            pointcut = "miv.study.aopdemo.aspect.AopExpressions.afterThrowingPointcut()",
            throwing = "exception"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Exception exception) {
        System.out.println("####> After throwing advice: " + exception);
    }

    @After("miv.study.aopdemo.aspect.AopExpressions.afterThrowingPointcut()")
    public void afterFindAccountAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("@@@@> Executing @After (finally) advice on method: " + method);
    }

    @Around("execution(* miv.study.aopdemo.service.*.get*(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable{
        // print out method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===> Executing @Around on method: " + method);
        // get begin stamp
        long begin = System.currentTimeMillis();
        // execute the method
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            System.out.println("@Around advice: we have an exception: " + e);
            System.out.println("@Around advice: we handled the exception.");
            result = "Nothing exciting here. Move along!";
        }
        // get end stamp
        long end = System.currentTimeMillis();
        // calculate duration
        long duration = end - begin;
        System.out.println("===> Duration: " + duration + "ms");
        return result;
    }
}
