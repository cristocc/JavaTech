package study.listener;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by crist on 2021/6/16
 *
 * @author cc
 */
public class Test {

    public static void main(String[] args) {
        testListener();
    }

    private static void testListener(){
        AbstractApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:/repo-2017/JavaTech/com/spring/study/spring.xml");
        EmailService emailService = (EmailService) applicationContext.getBean("emailService");
        emailService.sendEmail("known.spammer@example.org","123");

    }
}
