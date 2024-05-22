package com.ecommerce.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(ControllerLoggingAspect.class);

    @Before("execution(* com.ecommerce.controller.*.*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        logger.info("Calling controller method: {} with arguments: {}",
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.ecommerce.controller.*.*(..))", returning = "result")
    public void logAfterReturningController(JoinPoint joinPoint, Object result) {
        logger.info("Controller method executed successfully: {} with return value: {}",
                joinPoint.getSignature().toShortString(),
                result);
    }
}
