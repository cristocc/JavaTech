package study.spring.a9;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* study.spring.a9.MyService.foo())")
    public void before(){
        System.out.println("before");
    }
}
