package com.spring.study.model;

/**
 * Created by crist on 2021/5/14
 *
 * @author cc
 */
public class Dog {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
