package study.model;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by crist on 2021/5/13
 *
 * @author cc
 */
@Component
public class User implements InitializingBean {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {

    }

    public void init(){
        System.out.println("Bean初始化.....");
    }
    //bean销毁时调用的方法
    public void destroy(){
        System.out.println("Bean销毁.....");
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }


}
