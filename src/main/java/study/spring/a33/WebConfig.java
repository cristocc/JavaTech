package study.spring.a33;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.function.*;
import org.springframework.web.servlet.function.support.HandlerFunctionAdapter;
import org.springframework.web.servlet.function.support.RouterFunctionMapping;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.CachingResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.resource.ResourceResolver;
import study.spring.a20.MyRequestMappingHandlerAdapter;
import study.spring.a20.TokenArgumentResolver;
import study.spring.a20.YmlReturnValueHandler;
import techArticle.java.designPattern.factory.example1.RouJiaMo;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

/*    @Bean
    public BeanNameUrlHandlerMapping beanNameUrlHandlerMapping(){
        return new BeanNameUrlHandlerMapping();
    }

    @Bean
    public SimpleControllerHandlerAdapter simpleControllerHandlerAdapter(){
        return new SimpleControllerHandlerAdapter();
    }*/

    @Component
    static class MyHandlerAdapter implements HandlerAdapter {


        @Override
        public boolean supports(Object handler) {
            return handler instanceof Controller;
        }

        @Override
        public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            if(handler instanceof Controller ){
                ((Controller) handler).handleRequest(request,response);
            }
            return null;
        }

        @Override
        public long getLastModified(HttpServletRequest request, Object handler) {
            return 0;
        }
    }

    @Component
    static class MyHandlerMapping implements HandlerMapping{

        @Override
        public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
            String key = request.getRequestURI();
            Controller controller = collect.get(key);
            if(null == controller){
                return null;
            }
            return new HandlerExecutionChain(controller);
        }
        @Autowired
        private ApplicationContext context;
        private Map<String,Controller> collect;

        @PostConstruct
        public void init(){
            Map<String,Controller> map = context.getBeansOfType(Controller.class);
            collect = map.entrySet().stream()
                    .filter(e -> e.getKey().startsWith("/"))
                    .collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue()));
            System.out.println("---------------");
            System.out.println(collect);


        }
    }

    @Component("/c1")
    public static class Controller1 implements Controller{

        @Override
        public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
            response.getWriter().println("this is c1");
            return null;
        }
    }

    @Bean("/c2")
    public Controller controller2(){
        return ( request,  response) ->{
            response.getWriter().println("this is c2");
            return null;
        };
    }

    // RouterFunctionMapping handlerFunctionAdapter
    @Bean
    public RouterFunctionMapping routerFunctionMapping(){
        return new RouterFunctionMapping();
    }

    @Bean
    public HandlerFunctionAdapter handlerFunctionAdapter(){
        return new HandlerFunctionAdapter();
    }

    @Bean
    public RouterFunction<ServerResponse> r1(){
        return RouterFunctions.route(RequestPredicates.GET("/r1"), request -> {
            return ServerResponse.ok().body("this is r1");
        });
    }

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping(ApplicationContext context){
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Map<String,ResourceHttpRequestHandler> map = context.getBeansOfType(ResourceHttpRequestHandler.class);
        mapping.setUrlMap(map);
        return mapping;
    }

    @Bean
    public HttpRequestHandlerAdapter httpRequestHandlerAdapter(){
        return new HttpRequestHandlerAdapter();
    }

    @Bean("/img/**")
    public ResourceHttpRequestHandler handler1(){
        ResourceHttpRequestHandler handler = new ResourceHttpRequestHandler();
        handler.setLocations(Collections.singletonList(new ClassPathResource("images/")));
        List<ResourceResolver> resourceResolvers = new ArrayList<>();
        resourceResolvers.add(new CachingResourceResolver(new ConcurrentMapCache("cache")));
        resourceResolvers.add(new PathResourceResolver());
        handler.setResourceResolvers(resourceResolvers);
        return handler;
    }


}
