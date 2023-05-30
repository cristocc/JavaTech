package study.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * spring 选择代理
 */
public class A15 {

    public static void main(String[] args) {
        //1准备切面
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* foo())");
        //2备好通知
        MethodInterceptor advice = methodInvocation -> {
            System.out.println("before");
            Object result = methodInvocation.proceed();
            System.out.println("after");
            return result;
        };
        //3备好切面
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut,advice);

        //4创建代理
        Target1 t1 = new Target1();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(t1);
        factory.addAdvisor(advisor);
        //factory.setInterfaces(t1.getClass().getInterfaces());
        I1 proxy = (I1)factory.getProxy();
        proxy.foo();
        proxy.bar();

        System.out.println(proxy.getClass());

        /**
         * a.proxyTargetClass = false , 目标实现了接口 用jdk实现
         * b.proxyTargetClass = false ,目标没有实现接口，用cglib实现
         * c.proxyTargetClass = true 用cglib实现
         */
    }

    interface I1{
        void foo();
        void bar();
    }

    static class Target1 implements I1{
        @Override
        public void foo() {
            System.out.println("Target1 foo");
        }
        @Override
        public void bar() {
            System.out.println("Target1 bar");
        }
    }

    static class Target2 implements I1{
        @Override
        public void foo() {
            System.out.println("Target2 foo");
        }
        @Override
        public void bar() {
            System.out.println("Target2 bar");
        }
    }
}
