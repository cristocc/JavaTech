package study.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by crist on 2021/5/14
 *
 * @author cc
 */
@Component
public class Student implements DisposableBean, InitializingBean, BeanPostProcessor {

    //Student构造函数
    //Student customInit
    //Student afterPropertiesSet

    @Autowired
    @Qualifier(value = "user")
    private User user;

    @Value("cc")
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public Student() {

        System.out.println("Student构造函数");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Student afterPropertiesSet");
    }

    @PostConstruct
    public void customInit(){
        System.out.println("Student customInit");
    }

    @PreDestroy
    public void customDestory(){
        System.out.println("Student customDestory");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       // System.out.println("postProcessBeforeInitialization："+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
       // System.out.println("postProcessAfterInitialization："+beanName);
        return bean;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
