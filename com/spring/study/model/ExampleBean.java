package com.spring.study.model;

/**
 * Created by crist on 2021/6/8
 *
 * @author cc
 */
public class ExampleBean {

    private int years;
    private String ultimateAnswer;

    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }

    @Override
    public String toString() {
        return "ExampleBean{" +
                "years=" + years +
                ", ultimateAnswer='" + ultimateAnswer + '\'' +
                '}';
    }
}
