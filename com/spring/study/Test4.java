package com.spring.study;

import com.spring.study.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by crist on 2021/5/14
 *
 * @author cc
 */
public class Test4 {

    public static void main(String[] args)throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Employee cat = (Employee)applicationContext.getBean("employee");
        //调用方法
        System.out.println(cat.toString());
        System.out.println(cat.getDateOfBirth());
    }
}
