package study.spring.a20;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class A20 {

    public static void main(String[] args) throws Exception {
        AnnotationConfigServletWebServerApplicationContext context =
                new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);

/*        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
        handlerMethods.forEach((k,v)->{
            System.out.print("k="+k);
            System.out.print("v="+v);
            System.out.println();
        });*/
        MockHttpServletRequest request = new MockHttpServletRequest("GET","/test1");
        MockHttpServletResponse response = new MockHttpServletResponse();

        MyRequestMappingHandlerAdapter adapter = context.getBean(MyRequestMappingHandlerAdapter.class);
        RequestMappingHandlerMapping handlerMapping = context.getBean(RequestMappingHandlerMapping.class);
        HandlerExecutionChain chain = handlerMapping.getHandler(request);
        adapter.invokeHandlerMethod(request,response,(HandlerMethod)chain.getHandler());
        //System.out.println(chain);



       // adapter.invokeHandlerMethod(request,response,(HandlerMethod)chain.getHandler());
/*        System.out.println("----参数解析器-----");
        List<HandlerMethodArgumentResolver>  list = adapter.getArgumentResolvers();
        list.forEach(System.out::println);
        System.out.println("----返回值解析器-----");
        List<HandlerMethodReturnValueHandler> returnList = adapter.getReturnValueHandlers();
        returnList.forEach(System.out::println);*/
        {
/*            request = new MockHttpServletRequest("PUT","/test3");
            request.addHeader("token","abcde");
            chain = handlerMapping.getHandler(request);
            adapter.invokeHandlerMethod(request,response,(HandlerMethod)chain.getHandler());*/
        }

        {
            request = new MockHttpServletRequest("GET","/test4");
            chain = handlerMapping.getHandler(request);
            adapter.invokeHandlerMethod(request,response,(HandlerMethod)chain.getHandler());
            byte[] content = response.getContentAsByteArray();
            System.out.println(new String(content,"UTF-8"));
        }

        {
/*            request = new MockHttpServletRequest("GET","/test5");
            request.setParameter("name","cc");
            request.setParameter("age","10");
            chain = handlerMapping.getHandler(request);
            List<HandlerMethodArgumentResolver> resolvers = new ArrayList<>();
            resolvers.add(new ServletModelAttributeMethodProcessor(false));
            resolvers.add(new ServletModelAttributeMethodProcessor(true));
            adapter.setArgumentResolvers(resolvers);
            adapter.invokeHandlerMethod(request,response,(HandlerMethod)chain.getHandler());*/
        }

    }
}
