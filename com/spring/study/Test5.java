package com.spring.study;

import com.spring.study.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by crist on 2021/5/14
 *
 * @author cc
 */
public class Test5 {

    public static void main(String[] args)throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        MyService cat = (MyService)applicationContext.getBean("myService");
        //调用方法
        System.out.println();
        cat.method();
    }
}
