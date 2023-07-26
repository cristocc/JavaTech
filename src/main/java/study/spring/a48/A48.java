package study.spring.a48;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class A48 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(A48.class);
        context.getBean(MyService.class).doSomething();
        context.close();

    }

    @Component
    static class MyService{
        @Autowired
        private ApplicationEventPublisher publisher;

        public void doSomething(){
            System.out.println("doSomething");
            System.out.println("listener do other thing");
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
    static class SmsListener implements ApplicationListener<MyEvent>{

        @Override
        public void onApplicationEvent(MyEvent event) {
            System.out.println("SmsListener send sms");
        }
    }

    @Component
    static class EmailListener implements ApplicationListener<MyEvent>{

        @Override
        public void onApplicationEvent(MyEvent event) {
            System.out.println("EmailListener send email");
        }
    }



}
