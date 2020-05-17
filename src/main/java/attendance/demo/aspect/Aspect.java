package attendance.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
public class Aspect {

    @Before("execution(* *..*.add*(..))")
    public void printBefore(JoinPoint joinPoint){

    }

    @After("execution(* *..*.*(..))")
    public void printAfter(JoinPoint joinPoint){
        Object[] group  = joinPoint.getArgs();
        String name = (String)group[0];
        String className= joinPoint.getClass().getName();
        System.out.println(name+ " has just added as "+className);


    }
    @AfterReturning("execution(* *..*.add*(..))")
    public void afterAdding(JoinPoint joinPoint){
        Object[] group  = joinPoint.getArgs();
        String name = (String)group[0];
        String className= joinPoint.getClass().getName();
        System.out.println(name+ " has just added as "+className);


    }
}
