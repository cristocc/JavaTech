package study.spring.a20;


import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Collections;
import java.util.List;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableConfigurationProperties({WebMvcProperties.class, ServerProperties.class})
public class WebConfig {

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(ServerProperties properties){
        return new TomcatServletWebServerFactory(properties.getPort());
    }

    @Bean
    public DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    }

    @Bean
    public DispatcherServletRegistrationBean dispatcherServletRegistrationBean(DispatcherServlet dispatcherServlet ,WebMvcProperties properties){
        DispatcherServletRegistrationBean bean = new DispatcherServletRegistrationBean(dispatcherServlet,"/");
        bean.setLoadOnStartup(properties.getServlet().getLoadOnStartup());
        return bean;
    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping(){
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public MyRequestMappingHandlerAdapter requestMappingHandlerAdapter(){
        TokenArgumentResolver resolver = new TokenArgumentResolver();
        YmlReturnValueHandler ymlReturnValueHandler = new YmlReturnValueHandler();
        MyRequestMappingHandlerAdapter adapter = new MyRequestMappingHandlerAdapter();
        adapter.setCustomArgumentResolvers(Collections.singletonList(resolver));
        adapter.setCustomReturnValueHandlers(Collections.singletonList(ymlReturnValueHandler));
        return adapter;
    }
}
