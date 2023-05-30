package study.spring;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyDemo {

    interface Foo{
        void foo();
    }

    static class Target implements Foo{

        @Override
        public void foo() {
            System.out.println("foo");
        }
    }

    public static void main(String[] args) throws IOException {
        Target t = new Target();

        ClassLoader cl = JdkProxyDemo.class.getClassLoader();
        Foo proxy = (Foo) Proxy.newProxyInstance(cl, new Class[]{Foo.class}, (p, method, args1) -> {
            System.out.println("before");
            Object result = method.invoke(t,args);
            System.out.println("end");
            return result;
        });

        proxy.foo();
        System.out.println(proxy.getClass());
        System.out.println(proxy.toString());

        //System.in.read();
    }
}
