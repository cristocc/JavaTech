package com.spring.study.util;

/**
 * Created by crist on 2021/6/9
 *
 * @author cc
 */
public class Command {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object execute(){
        System.out.println(this.state+"execute");
        return new Object();
    }

    @Override
    public String toString() {
        return "Command{" +
                "state='" + state + '\'' +
                '}';
    }
}
