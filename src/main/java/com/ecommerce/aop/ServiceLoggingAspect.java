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
public class ServiceLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLoggingAspect.class);

    @Before("execution(* com.ecommerce.service.*.*(..))")
    public void logBeforeService(JoinPoint joinPoint) {
        logger.info("Calling service method: {} with arguments: {}",
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.ecommerce.service.*.*(..))", returning = "result")
    public void logAfterReturningService(JoinPoint joinPoint, Object result) {
        logger.info("Service method executed successfully: {} with return value: {}",
                joinPoint.getSignature().toShortString(),
                result);
    }
}
