package study.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class InitBean implements InitializingBean, DisposableBean {

    @PostConstruct
    public void init1(){
        //第一位执行
    }
    @PreDestroy
    public void destroy1(){
        //第一位执行
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //第二位执行
    }
    @Override
    public void destroy() throws Exception {
        //第二位执行
    }

    public void init3(){
        //第三位执行
    }

/*    @Bean(initMethod = "init3")
    public InitBean bean1(){
        return new InitBean();
    }*/
}
