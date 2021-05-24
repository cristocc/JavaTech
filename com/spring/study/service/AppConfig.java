package com.spring.study.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by crist on 2021/5/17
 *
 * @author cc
 */
@Configuration
public class AppConfig {

    @Bean
    public MyService myService(){
        return new MyServiceImpl();
    }
}
