package study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by crist on 2022/10/31
 *
 * @author cc
 */
@Aspect
@Component
public class AspectJTest {

    //https://mp.weixin.qq.com/s/w_lJ3SVjK4H88xDizktR0A

    ThreadLocal l = new ThreadLocal();

    /**
     * 定义的切点
     */
    @Pointcut("execution(* *.test(..))")
    public void test(){}

    /**
     * 前置通知
     */
    @Before("test()")
    public void beforeTest() {
        System.out.println("beforeTest()...");
    }

    /**
     * 后置通知
     */
    @After("test()")
    public void after() {
        System.out.println("afterTest()...");
    }

    /**
     * 环绕通知
     * @param p
     * @return
     */
    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p) {
        System.err.println("beforeTest by @Around...");
        Object o = null;
        try {
            // 处理
            o = p.proceed();
        } catch (Throwable a) {
            a.printStackTrace();
        }
        System.err.println("afterTest by @Around...");
        return o;
    }

}
