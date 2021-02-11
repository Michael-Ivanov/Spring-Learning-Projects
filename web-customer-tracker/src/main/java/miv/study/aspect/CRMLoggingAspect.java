package miv.study.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* miv.study.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* miv.study.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* miv.study.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // add @Before
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        // display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> in @Before: calling method: " + method);
        // display the args to the method
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("====> argument: " + arg);
        }

    }

    // add @AfterReturning
}
