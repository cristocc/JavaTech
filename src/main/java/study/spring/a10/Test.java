package study.spring.a10;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.A17;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import study.spring.a47.A47_1;

import java.util.List;

@Configuration
public class Test {

    public static void main(String[] args) {
        //-javaagent:C:/Users/crist/.m2/repository/org/aspectj/aspectjweaver/1.7.4/aspectjweaver-1.7.4.jar
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(AnnotationAwareAspectJAutoProxyCreator.class);
        context.scan("study.spring.a10");
        context.refresh();

        MyService service = context.getBean(MyService.class);
        service.bar();
    }
}
