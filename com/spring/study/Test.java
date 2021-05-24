package com.spring.study;

import com.spring.study.model.Student;
import com.spring.study.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by crist on 2021/5/13
 *
 * @author cc
 */
public class Test{

    public static void main(String[] args) {
        init4();
    }

    private static void init2(){
        ClassPathResource resource = new ClassPathResource("spring.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        User obj = (User) factory.getBean("user");
        System.out.println(obj.toString());
    }

    private static void init1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //获取User实例
        User user = (User)applicationContext.getBean("user");
        //调用方法
        System.out.println(user.toString());

    }

    private static void init3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //获取User实例
        User user = (User)applicationContext.getBean("user");
        //调用方法
        System.out.println(user.toString());

    }

    private static void init4(){
        AbstractApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:/repo-2017/JavaTech/com/spring/study/spring.xml");
        //获取User实例
        Student user = (Student)applicationContext.getBean("student");
        //调用方法
        System.out.println(user.toString());
        System.out.println(user.getUser());
        //applicationContext.close();
    }

    private class a{

    }
}
