package study.spring.a9;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import study.spring.a39.A39;

@Configuration
@ComponentScan("study.spring.a9")
public class Test {

    public static void main(String[] args) {

        SpringApplication spring = new SpringApplication(Test.class);

        ConfigurableApplicationContext context = spring.run();

        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        MyService myService = context.getBean(MyService.class);
        myService.foo();

        context.close();

    }

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
        return new TomcatServletWebServerFactory();
    }
}
