package study.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by crist on 2022/10/31
 *
 * @author cc
 */
public class TestMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springtest.xml");
        TestBean bean = (TestBean)context.getBean("test");
        bean.test();
    }
}
