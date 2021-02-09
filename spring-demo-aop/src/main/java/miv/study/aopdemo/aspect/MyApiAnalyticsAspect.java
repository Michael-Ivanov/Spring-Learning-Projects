package miv.study.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class MyApiAnalyticsAspect {

    @Before("miv.study.aopdemo.aspect.AopExpressions.excludeGettersAndSetters()")
    public void anotherBeforeAdvice() {
        System.out.println(">> Executing analytics advice on all methods");
    }

}
