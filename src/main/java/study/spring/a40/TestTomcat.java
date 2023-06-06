package study.spring.a40;


import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestTomcat {

    public static void main(String[] args) throws Exception {
        WebApplicationContext applicationContext = getWebApplicationContext();
        //1.创建tomcat对象
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("tomcat");
        //2.创建项目文件夹 docBase文件夹
        File docBase = Files.createTempDirectory("boot.").toFile();
        docBase.deleteOnExit();
        //3.创建tomcat项目
        Context context = tomcat.addContext("",docBase.getAbsolutePath());
        //4.添加Servlet
        context.addServletContainerInitializer(new ServletContainerInitializer() {
            @Override
            public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
                HelloServlet servlet = new HelloServlet();
                ctx.addServlet("hello",servlet).addMapping("/hello");

                DispatcherServlet dispatcherServlet = applicationContext.getBean(DispatcherServlet.class);
                ctx.addServlet("dispatcherServlet",dispatcherServlet).addMapping("/");
            }
        }, Collections.emptySet());

        tomcat.start();
        Connector connector = new Connector("HTTP/1.1");
        connector.setPort(8081);

        tomcat.setConnector(connector);

        while (true){

        }
    }

    public static WebApplicationContext getWebApplicationContext(){
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(Config.class);
        context.refresh();
        return context;
    }

    @Configuration
    static class Config{
        @Bean
        public DispatcherServletRegistrationBean dispatcherServletRegistrationBean(DispatcherServlet dispatcherServlet){
            return new DispatcherServletRegistrationBean(dispatcherServlet,"/");
        }

        @Bean
        public DispatcherServlet dispatcherServlet(WebApplicationContext context){
            return new DispatcherServlet(context);
        }
        @Bean
        public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
            RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
            adapter.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
            return adapter;
        }

        @RestController
        static class MyController{
            @GetMapping("hello2")
            public Map<String,Object> hello(){
                Map<String,Object> map = new HashMap<>();
                map.put("hello2","hello2,spring");
                return map;
            }

        }
    }
}
