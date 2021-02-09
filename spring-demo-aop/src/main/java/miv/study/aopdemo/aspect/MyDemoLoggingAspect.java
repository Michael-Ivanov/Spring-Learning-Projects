package miv.study.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging
//    @Before("execution(public void add*())")
    @Pointcut("execution(* miv.study.aopdemo.dao.*.*(..))")
    private void myPointcut() {}

    // create pointcut for getter methods
    @Pointcut("execution(* miv.study.aopdemo.dao.*.get*(..))")
    private void getterPoint() {}

    // create pointcut for setter methods
    @Pointcut("execution(* miv.study.aopdemo.dao.*.set*(..))")
    private void setterPoint() {}

    // create pointcut: include package && exclude getters/setters
    @Pointcut("myPointcut() && !(getterPoint() || setterPoint())")
    private void excludeGettersAndSetters() {}

    @Before("excludeGettersAndSetters()")
    public void beforeAddAccountAdvice() {
        System.out.println(">> Executing @Before excluding getters/setters");
    }

    @Before(value = "myPointcut()")
    public void anotherBeforeAdvice() {
        System.out.println(">> Executing another advice on all methods");
    }
}
