package by.java.converter.aspects;

import by.java.converter.counter.Counter;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Getter
@Setter
@Slf4j
@Component
public class CounterAspects {

  private final Counter counter = new Counter();

  @Pointcut("execution(* by.java.converter.service.*.*(..))")
  public void mainService() {}

  /**
   * Incrementation of counter.
   */
  @Before("mainService()")
  public synchronized void incrementBefore() {

    counter.inc();
    log.info("Current number of service calls: {}.", counter.getCount());
  }
}
