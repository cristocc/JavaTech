package com.spring.study.model;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by crist on 2021/5/14
 *
 * @author cc
 */
public class Cat implements InitializingBean {

    private Dog dog;

    private String name;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat afterPropertiesSet");
    }
}
