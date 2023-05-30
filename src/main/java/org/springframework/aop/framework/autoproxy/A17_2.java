package org.springframework.aop.framework.autoproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectInstanceFactory;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;
import org.springframework.aop.aspectj.SingletonAspectInstanceFactory;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class A17_2 {

    public static void main(String[] args) throws NoSuchMethodException {
        AspectInstanceFactory factory = new SingletonAspectInstanceFactory(new Aspect1());
        List<Advisor> list = new ArrayList<>();
        for (Method method : Aspect1.class.getDeclaredMethods()) {
            if(method.isAnnotationPresent(Before.class)){
                String expression = method.getAnnotation(Before.class).value();
                AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
                pointcut.setExpression(expression);
                AspectJMethodBeforeAdvice advice = new AspectJMethodBeforeAdvice(method,pointcut,factory);
                Advisor advisor = new DefaultPointcutAdvisor(pointcut,advice);
                list.add(advisor);
            }
        }
        list.forEach(System.out::println);

    }

    @Aspect
    static class Aspect1{
        @Before("execution(* foo())")
        public void before(){
            System.out.println("before");
        }

        @Before("execution(* foo())")
        public void before1(){
            System.out.println("before1");
        }

        @After("execution(* foo())")
        public void after(){
            System.out.println("after");
        }
    }

    static class Target1{
        public void foo(){
            System.out.println("Target1 foo");
        }
    }
}
