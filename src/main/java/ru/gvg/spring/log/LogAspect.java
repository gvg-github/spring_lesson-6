package ru.gvg.spring.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Valeriy Gyrievskikh
 * @since 08.08.2018.
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* ru.gvg.spring.controller..*.*(..))")
    private void getName(){
    }

    @Before("getName()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println(joinPoint);
    }
}
