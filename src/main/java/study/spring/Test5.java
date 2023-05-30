package study.spring;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.context.support.GenericApplicationContext;

public class Test5 {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        //context.registerBean("myBean", MyBean.class);
        context.registerBean("myConfig1",MyConfig1.class);
        //生效 autowired
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);

        context.registerBean(CommonAnnotationBeanPostProcessor.class);
        //<context:component-scan/> @Configuration
        context.registerBean(ConfigurationClassPostProcessor.class);

        context.refresh();
        context.close();
    }
}
