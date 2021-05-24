package com.spring.study.service;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Service;

/**
 * Created by crist on 2021/5/17
 *
 * @author cc
 */
@Service
public class MessageService implements MessageSourceAware {

    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
        System.out.println(messageSource);
    }
}
