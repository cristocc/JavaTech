package study.spring.a46;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Configuration
public class A46 {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(A46.class);
        //context.scan("study.spring.a46");

        DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();

        ContextAnnotationAutowireCandidateResolver resolver = new ContextAnnotationAutowireCandidateResolver();
        resolver.setBeanFactory(beanFactory);

       //context.registerBean(ConfigurationClassPostProcessor.class);
        //context.registerBean(AnnotationAwareAspectJAutoProxyCreator.class);
        //context.refresh();

/*        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        System.out.println(context.getBean("bean3"));*/
        System.out.println(context.getBean("bean4"));


        //Field home = Bean1.class.getDeclaredField("home");
        //extracted(context, resolver, home);
        //Field age = Bean1.class.getDeclaredField("age");
        //extracted1(context, resolver, age);

       // extracted2(context, resolver, Bean2.class.getDeclaredField("bean3"));
    }

    private static void extracted2(AnnotationConfigApplicationContext context, ContextAnnotationAutowireCandidateResolver resolver, Field field) {
        DependencyDescriptor dd = new DependencyDescriptor(field,false);
        resolver.getSuggestedValue(dd);
        String value = resolver.getSuggestedValue(dd).toString();
        System.out.println(value);
        //解析${}
        value = context.getEnvironment().resolvePlaceholders(value);
        System.out.println(value);
        System.out.println(value.getClass());
        //解析#{}
        StandardBeanExpressionResolver StandardBeanExpressionResolver = new StandardBeanExpressionResolver();
        context.getBeanFactory().setBeanExpressionResolver(StandardBeanExpressionResolver);
        Object bean3 = context.getBeanFactory().getBeanExpressionResolver()
                .evaluate(value,new BeanExpressionContext(context.getBeanFactory(),null));

        Object result = context.getBeanFactory().getTypeConverter().convertIfNecessary(bean3,dd.getDependencyType());
        System.out.println(result);
    }
    private static void extracted1(AnnotationConfigApplicationContext context, ContextAnnotationAutowireCandidateResolver resolver, Field field) {
        DependencyDescriptor dd = new DependencyDescriptor(field,false);
        resolver.getSuggestedValue(dd);

        String value = resolver.getSuggestedValue(dd).toString();
        System.out.println(value);

        value = context.getEnvironment().resolvePlaceholders(value);
        System.out.println(value);

        System.out.println(value.getClass());

        Object age = context.getBeanFactory().getTypeConverter().convertIfNecessary(value,dd.getDependencyType());
        System.out.println(age.getClass());
    }


    private static void extracted(AnnotationConfigApplicationContext context, ContextAnnotationAutowireCandidateResolver resolver, Field field) {
        DependencyDescriptor dd = new DependencyDescriptor(field,false);
        resolver.getSuggestedValue(dd);

        String value = resolver.getSuggestedValue(dd).toString();
        System.out.println(value);
        //解析 ${}
        value = context.getEnvironment().resolvePlaceholders(value);
        System.out.println(value);
    }

    public class Bean1{
        @Value("${JAVA_HOME}")
        private String home;

        @Value("18")
        private int age;

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Bean1{" +
                    "home='" + home + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public class Bean2{
        @Value("#{@bean3}")
        private Bean3 bean3;

        @Value("#{@bean4}")
        private Bean4 bean4;

    }

    @Component("bean4")
    public class Bean4{

    }



}
