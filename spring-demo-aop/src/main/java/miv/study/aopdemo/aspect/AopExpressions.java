package miv.study.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* miv.study.aopdemo.dao.*.*(..))")
    public void myPointcut() {}

    // create pointcut for getter methods
    @Pointcut("execution(* miv.study.aopdemo.dao.*.get*(..))")
    public void getterPoint() {}

    // create pointcut for setter methods
    @Pointcut("execution(* miv.study.aopdemo.dao.*.set*(..))")
    public void setterPoint() {}

    // create pointcut: include package && exclude getters/setters
    @Pointcut("myPointcut() && !(getterPoint() || setterPoint())")
    public void excludeGettersAndSetters() {}
}
