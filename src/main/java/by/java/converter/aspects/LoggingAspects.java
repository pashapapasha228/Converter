package by.java.converter.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Slf4j
@Aspect
public class LoggingAspects {
    @Pointcut("execution(* by.java.converter.service.*.*(..))")
    public void allMethods() {

    }

    @Before("allMethods()")
    public void logBefore(JoinPoint joinPoint) {

        if (joinPoint.getArgs().length != 0) {
            log.info("Started method " + joinPoint.getSignature().getName() + " with arguments "
                    + Arrays.stream(joinPoint.getArgs())
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        } else {
            log.info("Started method " + joinPoint.getSignature().getName() + " with no arguments");
        }
    }

    @AfterReturning("allMethods()")
    public void logAfterExecuting(JoinPoint joinPoint) {
        log.info("Method " + joinPoint.getSignature().getName() + " executed.");
    }

    @AfterThrowing(pointcut = "allMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.info("Method " + joinPoint.getSignature().getName() + " threw an exception "
                + exception.getClass().getSimpleName() + " with message " + exception.getMessage());
    }
}
