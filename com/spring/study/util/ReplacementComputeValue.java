package com.spring.study.util;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by crist on 2021/6/9
 *
 * @author cc
 */
public class ReplacementComputeValue implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        String input = (String) args[0];
        System.out.println("reimplement");
        return null;
    }
}
