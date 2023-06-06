package study.spring;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import study.spring.a27.A27.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_XML;

public class a28 {

    public static void main(String[] args) throws Exception {
        test1();
    }

    public static void test1() throws IOException {
        MockHttpOutputMessage msg = new MockHttpOutputMessage();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        if(converter.canWrite(User.class, APPLICATION_JSON)){
            converter.write(new User("abc"),APPLICATION_JSON,msg);
            out.println(new String(msg.getBodyAsBytes(),"UTF-8"));
        }
    }

    public static void test2() throws IOException {
        MockHttpOutputMessage msg = new MockHttpOutputMessage();
        MappingJackson2XmlHttpMessageConverter converter = new MappingJackson2XmlHttpMessageConverter();
        if(converter.canWrite(User.class, APPLICATION_XML)){
            converter.write(new User("abc"),APPLICATION_XML,msg);
            out.println(new String(msg.getBodyAsBytes(),"UTF-8"));
        }
    }

    public static void test3() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        ServletWebRequest webRequest = new ServletWebRequest(request,response);
        request.addHeader("Accept","application/xml");
        response.setContentType("application/json");

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        //1.优先根据 setContentType
        //2.addHeader 设置application/xml
        //3.根据 msgconverter 顺序
        list.add(new MappingJackson2XmlHttpMessageConverter());
        list.add(new MappingJackson2HttpMessageConverter());

        RequestResponseBodyMethodProcessor processor = new RequestResponseBodyMethodProcessor(list);
        processor.handleReturnValue(
                new User("abc"),
                new MethodParameter(User.class.getMethod("user"),-1),
                new ModelAndViewContainer(),
                webRequest);

        System.out.println(new String(response.getContentAsByteArray(),"UTF-8"));

    }

}
