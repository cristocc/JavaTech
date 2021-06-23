package com.spring.study.util;

import com.spring.study.model.LifecycleExampleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by crist on 2021/6/15
 *
 * @author cc
 */
@Configuration
public class AppConfigDemo {

    @Bean(initMethod = "init")
    public LifecycleExampleBean lifecycleExampleBean() {
        return new LifecycleExampleBean();
    }
}
