package study.spring;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.transaction.annotation.Transactional;

public class A16 {

    public static void main(String[] args) throws NoSuchMethodException {
        {
            AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
            pointcut.setExpression("execution(* bar())");
            System.out.println(pointcut.matches(T1.class.getMethod("foo"),T1.class));
            System.out.println(pointcut.matches(T1.class.getMethod("bar"),T1.class));
        }

        {
            AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
            pointcut.setExpression("@annotation(org.springframework.transaction.annotation.Transactional)");
            System.out.println(pointcut.matches(T1.class.getMethod("foo"),T1.class));
            System.out.println(pointcut.matches(T1.class.getMethod("bar"),T1.class));
        }

    }

    static class T1{
        @Transactional
        public void foo(){

        }
        public void bar(){

        }

    }

    @Transactional
    static class T2{
        public void foo(){

        }
    }
}
