package miv.study.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class MyCloudLogAsyncAspect {

    @Before("miv.study.aopdemo.aspect.AopExpressions.excludeGettersAndSetters()")
    public void logToCloudAsync() {
        System.out.println(">> Logging to Cloud in async fashion");
    }
}
