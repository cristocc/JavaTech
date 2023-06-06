package study.spring.a10;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

    @Before("execution(* study.spring.a10.MyService.*())")
    public void before(){
        System.out.println("before");
    }
}
