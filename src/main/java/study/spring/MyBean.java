package study.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

class MyBean implements BeanNameAware , ApplicationContextAware , InitializingBean {

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName:"+s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext:"+applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Autowired
    public void test1(ApplicationContext applicationContext){
        System.out.println("test1");
    }
}
