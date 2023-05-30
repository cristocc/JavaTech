package study.spring;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyDemo {

    static class Target{
        //不能是final
        public void foo(){
            System.out.println("foo");
        }
    }

    //代理是子类，目标是父类
    public static void main(String[] args) {
        Target t = new Target();
        Target proxy = (Target)Enhancer.create(Target.class, (MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("before");
            Object result = method.invoke(t,objects); //用方法反射
            //Object result = methodProxy.invoke(t,objects); 内部没有反射
            System.out.println("end");
            return result;
        });
        proxy.foo();
    }
}
