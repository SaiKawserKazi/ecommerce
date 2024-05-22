package com.ecommerce.aop;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(* com.ecommerce.service.SaleService.getTotalSaleAmountForToday(..))")
    public void logServiceMethodCall(JoinPoint joinPoint) {
        log.info("Executing method: {}", joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            log.info("Method arguments: {}", Arrays.toString(args));
        }
    }

    @AfterReturning(pointcut = "execution(* com.ecommerce.service.SaleService.getTotalSaleAmountForToday(..))", returning = "result")
    public void logServiceMethodReturn(JoinPoint joinPoint, Object result) {
        log.info("Method executed successfully: {}", joinPoint.getSignature());
        log.info("Method return value: {}", result);
    }
}
