package study.model;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by crist on 2021/6/10
 *
 * @author cc
 */
@Component
public class LifecycleExampleBean implements InitializingBean, DisposableBean, SmartLifecycle, BeanNameAware {

    //notice
    //Multiple lifecycle mechanisms configured for the same bean, with different initialization methods, are called as follows:
    //Methods annotated with @PostConstruct
    //afterPropertiesSet() as defined by the InitializingBean callback interface
    //A custom configured init() method

    //Destroy methods are called in the same order:
    // Methods annotated with @PreDestroy
    //destroy() as defined by the DisposableBean callback interface
    //A custom configured destroy() method

    //setBeanName
    //@PostConstruct
    //afterPropertiesSet
    //init
    //start
    @PostConstruct
    public void testPostConstruct(){
        System.out.println("testPostConstruct");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName:"+name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //It is recommended that you do not use the InitializingBean interface because it unnecessarily couples the code to Spring.
        // Alternatively, use the @PostConstruct annotation or specify a POJO initialization method.
        // do some initialization work
        System.out.println("afterPropertiesSet");
    }

    public void init() {
        // do some initialization work
        // same as afterPropertiesSet
        System.out.println("init");
    }

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void destroy() throws Exception {
       // The destroy-method attribute of a <bean> element can be assigned a special (inferred) value which instructs Spring to automatically
        // detect a public close or shutdown method on the specific bean class (any class that implements java.lang.AutoCloseable or java.io.Closeable would therefore match).
        System.out.println("destroy");
    }

    public void cleanup() {
        // do some destruction work (like releasing pooled connections)
        //same as destroy
        System.out.println("cleanup");
    }
    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public boolean isRunning() {
        return false;
    }

}
