package study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by crist on 2021/5/14
 *
 * @author cc
 */
public class Test2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //获取User实例
        //Cat cat = (Cat)applicationContext.getBean("cat");
        //调用方法
        //System.out.println(cat.toString());

        String message = applicationContext.getMessage("msg.text", null, Locale.US);

        System.out.println(message);
    }
}
