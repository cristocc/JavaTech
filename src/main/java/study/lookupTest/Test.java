package study.lookupTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by crist on 2022/9/26
 *
 * @author cc
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("springlookuptest.xml");
        GetBeanTest bean = (GetBeanTest)applicationContext.getBean("getBeanTest");
        bean.showMe();
    }
}
