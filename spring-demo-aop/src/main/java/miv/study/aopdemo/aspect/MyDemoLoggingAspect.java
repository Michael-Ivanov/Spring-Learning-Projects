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
    @Pointcut("execution(* add*(String...))")
    private void myPointcut() {}


    @Before("myPointcut()")
    public void beforeAddAccountAdvice() {
        System.out.println(">> Executing @Before advice on add*()");
    }

    @Before(value = "myPointcut()")
    public void anotherBeforeAdvice() {
        System.out.println("another advice");
    }
}
