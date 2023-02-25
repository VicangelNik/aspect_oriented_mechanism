package org.example.udemy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author Nikiforos Xylogiannopoulos
 */
@Aspect
public class LoggingAspect {

  @Before("execution(* org.example.udemy.ProductServiceImpl.multiply(..))")
  public void logBefore(JoinPoint joinPoint) {
    System.out.println("Before Calling the method");
  }

  @After("execution(* org.example.udemy.ProductServiceImpl.multiply(..))")
  public void logAfter(JoinPoint joinPoint) {
    System.out.println("After the method execution");
  }
}
