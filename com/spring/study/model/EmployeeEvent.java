package com.spring.study.model;

import org.springframework.context.ApplicationEvent;

/**
 * Created by crist on 2021/5/17
 *
 * @author cc
 */
public class EmployeeEvent extends ApplicationEvent {

    private String eventType;
    private Employee employee;

    public EmployeeEvent(Object source, String eventType, Employee employee) {
        super(source);
        this.eventType = eventType;
        this.employee = employee;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
