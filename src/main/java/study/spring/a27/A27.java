package study.spring.a27;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.*;

import java.lang.reflect.Method;
import java.util.Collections;

public class A27 {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        ModelAndViewContainer container = new ModelAndViewContainer();
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletWebRequest webRequest = new ServletWebRequest(request);
        HandlerMethodReturnValueHandlerComposite composite = getReturnValueHandler();
        Controller controller = new Controller();
        {
/*
            Method method = Controller.class.getMethod("test1");
            Object returnValue = method.invoke(controller);
            HandlerMethod handlerMethod = new HandlerMethod(controller,method);
            if(composite.supportsReturnType(handlerMethod.getReturnType())){
                composite.handleReturnValue(returnValue,handlerMethod.getReturnType(),container,webRequest);
                System.out.println(container.getModel());
                System.out.println(container.getViewName());
            }
            */
        }

        {
/*            Method method = Controller.class.getMethod("test2");
            Object returnValue = method.invoke(controller);
            HandlerMethod handlerMethod = new HandlerMethod(controller,method);
            if(composite.supportsReturnType(handlerMethod.getReturnType())){
                composite.handleReturnValue(returnValue,handlerMethod.getReturnType(),container,webRequest);
                System.out.println(container.getModel());
                System.out.println(container.getViewName());
            }*/
        }

        {
            Method method = Controller.class.getMethod("test3");
            Object returnValue = method.invoke(controller);
            HandlerMethod handlerMethod = new HandlerMethod(controller,method);
            if(composite.supportsReturnType(handlerMethod.getReturnType())){
                composite.handleReturnValue(returnValue,handlerMethod.getReturnType(),container,webRequest);
                System.out.println(container.getModel());
                System.out.println(container.getViewName());
            }

        }


    }

    public static HandlerMethodReturnValueHandlerComposite getReturnValueHandler(){
        HandlerMethodReturnValueHandlerComposite composite = new HandlerMethodReturnValueHandlerComposite();
        composite.addHandler(new ModelAndViewMethodReturnValueHandler());
        composite.addHandler(new ViewNameMethodReturnValueHandler());
        composite.addHandler(new ServletModelAttributeMethodProcessor(false));
        composite.addHandler(new HttpEntityMethodProcessor(Collections.singletonList(new MappingJackson2HttpMessageConverter())));
        composite.addHandler(new HttpHeadersReturnValueHandler());
        composite.addHandler(new RequestResponseBodyMethodProcessor(Collections.singletonList(new MappingJackson2HttpMessageConverter())));
        composite.addHandler(new ServletModelAttributeMethodProcessor(true));

        return composite;
    }

    static class Controller{

        public ModelAndView test1(){
            ModelAndView mv = new ModelAndView("view1");
            mv.addObject("name","abc");
            return mv;

        }

        public String test2(){
            System.out.println("test2");
            return "view2";
        }

        @ModelAttribute
        public User test3(){
            System.out.println("test3");
            return new User("abc");
        }
    }

    public static class User{
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @ResponseBody
        public User user(){
            return null;
        }
    }
}
