package study.spring.a39;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.SpringFactoriesLoader;
import study.spring.InitBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

@Configuration
public class A39_1 {

    public static void main(String[] args) throws Exception {
        GenericApplicationContext context = new GenericApplicationContext();

        SpringApplication spring = new SpringApplication(A39_1.class);
        spring.addListeners(event -> System.out.println(event.getClass()));
        List<String> names = SpringFactoriesLoader.loadFactoryNames(SpringApplicationRunListener.class,A39_1.class.getClassLoader());
        for (String name:names) {

            Class<?> clz = Class.forName(name);
            Constructor<?> constructor = clz.getConstructor(SpringApplication.class,String[].class);
            SpringApplicationRunListener publisher = (SpringApplicationRunListener)constructor.newInstance(spring,args);
            publisher.starting();
            publisher.environmentPrepared(new StandardEnvironment());//环境信息准备完毕
            publisher.contextPrepared(context);//在spring容器创建，并调用初始化器之后，发送此事件
            publisher.contextLoaded(context); //所有bean definition加载完毕
            context.refresh();
            publisher.started(context);// spring 容器初始化完成 refresh（） 完成
            publisher.running(context);
            publisher.failed(context,new Throwable());
        }

        //ConfigurableApplicationContext context = spring.run();


        //context.close();

    }



}
