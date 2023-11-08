package com.ludiStudy.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // this is where we add all of our related advice for logging

    @Pointcut("execution(* com.ludiStudy.Repository.*.*(..))")
    private void forRepositoryPkg(){}

    @Before("forRepositoryPkg()")
    public void beforeAddAccount(){
        System.out.println("\n==========>>>> Executing @Before advice on addAccount");
    }

    @Before("forRepositoryPkg()")
    public void performAnalysis(){
        System.out.println("\n==========>>>> Executing @Before advice on addAccount- performAnalysis");
    }
}
