package study.spring.a39;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import study.spring.InitBean;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class A39 {

    public static void main(String[] args) throws Exception {

        SpringApplication spring = new SpringApplication(A39.class);

        ConfigurableApplicationContext context = spring.run();
        for (String name : context.getBeanDefinitionNames()) {
            //System.out.println(name);
            System.out.println(name+":"+context.getBeanFactory().getBeanDefinition(name).getResourceDescription());

        }

        context.close();

    }

    private static void addListeners(SpringApplication spring)  {
        spring.addListeners(event -> System.out.println("event:" + event));
    }

    private static void addInitializers(SpringApplication spring)  {
        spring.addInitializers(applicationContext -> {
            if(applicationContext instanceof GenericApplicationContext){
                Class<?> bean = InitBean.class;
                ((GenericApplicationContext) applicationContext).registerBean("initBean",bean);
            }
        });
    }

    private static void deduceFromClasspath() throws Exception {
        Method deduceFromClasspath = WebApplicationType.class.getDeclaredMethod("deduceFromClasspath");
        deduceFromClasspath.setAccessible(true);
        System.out.println(deduceFromClasspath.invoke(null));
    }

    private static void deduceMainApplicationClass(SpringApplication spring) throws Exception {
        Method deduceMainApplicationClass = SpringApplication.class.getDeclaredMethod("deduceMainApplicationClass");
        deduceMainApplicationClass.setAccessible(true);
        System.out.println(deduceMainApplicationClass.invoke(spring));
    }
    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
        return new TomcatServletWebServerFactory();
    }


}
