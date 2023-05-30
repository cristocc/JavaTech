package study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MyConfig1 {

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext){
        System.out.println("setApplicationContext");
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    // Autowired PostConstruct 失效
    @Bean
    public BeanFactoryPostProcessor processor(){
        return configurableListableBeanFactory -> {
            System.out.println("processor");
        };
    }
}
