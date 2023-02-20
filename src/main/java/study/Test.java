package study;

import org.openjdk.jol.info.ClassLayout;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.ClassPathResource;
import study.model.*;
import study.service.ClientService;
import study.util.Command;
import study.util.CommandManager;
import study.util.MyValueCalculator;

import javax.sound.midi.Soundbank;

/**
 * Created by crist on 2021/5/13
 *
 * @author cc
 */
public class Test{

    public static void main(String[] args) {
        init1();
        new AnnotationConfigApplicationContext("com.xiaoxizi.spring");
    }

    private static void init2(){
        ClassPathResource resource = new ClassPathResource("E:/repo-2017/JavaTech/com/spring/study/spring.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        User obj = (User) factory.getBean("user");
        System.out.println(obj.toString());
    }

    private static void init1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        //获取User实例
        User user = (User)applicationContext.getBean("user");
        //调用方法
        System.out.println(user.toString());
        System.out.println( ClassLayout.parseInstance(applicationContext).toPrintable());
        System.out.println( ClassLayout.parseInstance(user).toPrintable());



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

    private static void init5(){
        AbstractApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:/repo-2017/JavaTech/com/spring/study/spring.xml");
        //获取User实例
        ClientService obj = (ClientService)applicationContext.getBean("clientService");
        //调用方法
        System.out.println(obj.toString());
        //applicationContext.close();
    }


    private static void init6(){
        AbstractApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:/repo-2017/JavaTech/com/spring/study/spring.xml");
        //获取User实例
        ExampleBean obj = (ExampleBean)applicationContext.getBean("exampleBean");
        //调用方法
        System.out.println(obj.toString());
        //applicationContext.close();
        Cat obj1 = (Cat)applicationContext.getBean("cat");
        System.out.println(obj1.toString());
        System.out.println(obj1.getPerson());
    }


    private static void init7(){
        AbstractApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:/repo-2017/JavaTech/com/spring/study/spring.xml");
        //获取User实例
        CommandManager obj = (CommandManager)applicationContext.getBean("commandManager");
        //调用方法
        System.out.println(obj);

        CommandManager obj1 = (CommandManager)applicationContext.getBean("commandManager");
        System.out.println(obj == obj1);
        Command obj3 = (Command)applicationContext.getBean("myCommand");

        Command obj4 = (Command)applicationContext.getBean("myCommand");
        System.out.println(obj3 == obj4);
    }

    private static void init8(){
        AbstractApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:/repo-2017/JavaTech/com/spring/study/spring.xml");
        //获取User实例
        MyValueCalculator obj = (MyValueCalculator)applicationContext.getBean("myValueCalculator");
        //调用方法
        obj.computeValue(null);
    }

    private static void init9(){
        AbstractApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:/repo-2017/JavaTech/com/spring/study/spring.xml");

        //InheritedTestBean father = (InheritedTestBean) applicationContext.getBean("inheritedTestBean");
        DerivedTestBean son = (DerivedTestBean) applicationContext.getBean("inheritsWithDifferentClass");
        //System.out.println(father.toString());
        System.out.println(son.toString());

        Environment env = applicationContext.getEnvironment();
        MutablePropertySources sources = applicationContext.getEnvironment().getPropertySources();



    }
}
