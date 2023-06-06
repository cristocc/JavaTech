package study.spring.a26;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExpressionValueMethodArgumentResolver;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.*;
import study.spring.a20.MyRequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class A26 {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(WebConfig.class);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter("name","cc");
        MockHttpServletResponse response = new MockHttpServletResponse();

        ServletInvocableHandlerMethod handlerMethod = new ServletInvocableHandlerMethod
                (new WebConfig.Controller1(),WebConfig.Controller1.class.getMethod("foo",WebConfig.User.class));
        ServletRequestDataBinderFactory factory = new ServletRequestDataBinderFactory(null,null);
        handlerMethod.setDataBinderFactory(factory);
        handlerMethod.setParameterNameDiscoverer(new DefaultParameterNameDiscoverer());
        HandlerMethodArgumentResolverComposite composite = new HandlerMethodArgumentResolverComposite();
        composite.addResolvers(getDefaultInitBinderArgumentResolvers(context));
        handlerMethod.setHandlerMethodArgumentResolvers(composite);
        ModelAndViewContainer container = new ModelAndViewContainer();

        handlerMethod.invokeAndHandle(new ServletWebRequest(request),container);
        context.close();
    }

    private static List<HandlerMethodArgumentResolver> getDefaultInitBinderArgumentResolvers(AnnotationConfigApplicationContext context) {
        List<HandlerMethodArgumentResolver> resolvers = new ArrayList<>();

        // Annotation-based argument resolution
        resolvers.add(new RequestParamMethodArgumentResolver(context.getBeanFactory(), false));
        resolvers.add(new RequestParamMapMethodArgumentResolver());
        resolvers.add(new PathVariableMethodArgumentResolver());
        resolvers.add(new PathVariableMapMethodArgumentResolver());
        resolvers.add(new MatrixVariableMethodArgumentResolver());
        resolvers.add(new MatrixVariableMapMethodArgumentResolver());
        resolvers.add(new ExpressionValueMethodArgumentResolver(context.getBeanFactory()));
        resolvers.add(new SessionAttributeMethodArgumentResolver());
        resolvers.add(new RequestAttributeMethodArgumentResolver());

        // Type-based argument resolution
        resolvers.add(new ServletRequestMethodArgumentResolver());
        resolvers.add(new ServletResponseMethodArgumentResolver());
        resolvers.add(new ServletModelAttributeMethodProcessor(false));
        resolvers.add(new ServletModelAttributeMethodProcessor(true));

        // Custom arguments
/*        if (getCustomArgumentResolvers() != null) {
            resolvers.addAll(getCustomArgumentResolvers());
        }*/

        // Catch-all
        resolvers.add(new RequestParamMethodArgumentResolver(context.getBeanFactory(), true));

        return resolvers;
    }



}
