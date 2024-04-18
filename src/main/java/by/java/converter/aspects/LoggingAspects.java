package by.java.converter.aspects;

import java.util.Arrays;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Компонент логгирования.
 */
@Component
@Slf4j
@Aspect
public class LoggingAspects {
  @Pointcut("execution(* by.java.converter.service.*.*(..))")
  public void allMethods() {

  }

  /**
   * Перед всеми методами.
   */
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
