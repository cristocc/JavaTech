package study.spring.a48;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;


@Configuration
public class A48_2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(A48_2.class);
        context.getBean(MyService.class).doSomething();
        context.close();

    }

    @Component
    static class MyService{
        @Autowired
        private ApplicationEventPublisher publisher;

        Logger log = LoggerFactory.getLogger(MyService.class);

        public void doSomething(){
            log.info("doSomething");
            //System.out.println("doSomething");
            //System.out.println("listener do other thing");
            publisher.publishEvent(new MyEvent("MyService doSomething"));

        }
    }

    static class MyEvent extends ApplicationEvent{

        /**
         * Create a new {@code ApplicationEvent}.
         *
         * @param source the object on which the event initially occurred or with
         *               which the event is associated (never {@code null})
         */
        public MyEvent(Object source) {
            super(source);
        }
    }

    @Component
    static class SmsListener {

        Logger log = LoggerFactory.getLogger(SmsListener.class);
        @EventListener
        public void listener(MyEvent myEvent){
            log.info("send sms");
        }
    }


    @Component
    static class EmailListener {
        Logger log = LoggerFactory.getLogger(EmailListener.class);
        @EventListener
        public void listener(MyEvent myEvent){
            log.info("send Email");
        }
    }

    @Bean
    public ThreadPoolTaskExecutor executor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(100);
        return executor;
    }

    @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster(ThreadPoolTaskExecutor executor){
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setTaskExecutor(executor);
        return multicaster;
    }

}
