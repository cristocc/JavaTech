package com.spring.study.util;

import org.springframework.beans.factory.annotation.Lookup;

/**
 * Created by crist on 2021/6/9
 *
 * @author cc
 */
public abstract class CommandManager {


    public Object process(Object commandState) {
        // grab a new instance of the appropriate Command interface
        Command command = createCommand();
        // set the state on the (hopefully brand new) Command instance
        command.setState("test");
        return command.execute();
    }

    @Lookup
    protected abstract Command createCommand();
}
