package study.spring.a23;

import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.InvocableHandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ServletRequestDataBinderFactory;

import java.util.Collections;
import java.util.Date;

public class TestServletDataBinderFactory {

    public static void main(String[] args) throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter("birthDay","2020|01|01");
        request.setParameter("address.name","shanghai");
        User target = new User();

        // initBinder PropertyEditorRegistry PropertyEditor
        {
            InvocableHandlerMethod method = new InvocableHandlerMethod
                    (new MyController(),MyController.class.getMethod("aaa",WebDataBinder.class));
            ServletRequestDataBinderFactory factory = new ServletRequestDataBinderFactory(Collections.singletonList(method),null);
            WebDataBinder binder = factory.createBinder(new ServletWebRequest(request),target,"user");
            binder.bind(new ServletRequestParameterPropertyValues(request));
            System.out.println(target);
        }

        {
            //ConversionService
            FormattingConversionService service = new FormattingConversionService();
            service.addFormatter(new MyDateFormatter("FormattingConversionService"));
            ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
            initializer.setConversionService(service);

            ServletRequestDataBinderFactory factory = new ServletRequestDataBinderFactory(null,initializer);
            WebDataBinder binder = factory.createBinder(new ServletWebRequest(request),target,"user");
            binder.bind(new ServletRequestParameterPropertyValues(request));
            System.out.println(target);
        }

        {
            //优先使用InitBinder
            InvocableHandlerMethod method = new InvocableHandlerMethod
                    (new MyController(),MyController.class.getMethod("aaa",WebDataBinder.class));

            FormattingConversionService service = new FormattingConversionService();
            service.addFormatter(new MyDateFormatter("FormattingConversionService"));
            ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
            initializer.setConversionService(service);

            ServletRequestDataBinderFactory factory = new ServletRequestDataBinderFactory(Collections.singletonList(method),initializer);
            WebDataBinder binder = factory.createBinder(new ServletWebRequest(request),target,"user");
            binder.bind(new ServletRequestParameterPropertyValues(request));
            System.out.println(target);
        }

        {
            DefaultFormattingConversionService service = new DefaultFormattingConversionService();
            ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
            initializer.setConversionService(service);

            ServletRequestDataBinderFactory factory = new ServletRequestDataBinderFactory(null,initializer);

            WebDataBinder binder = factory.createBinder(new ServletWebRequest(request),target,"user");
            binder.bind(new ServletRequestParameterPropertyValues(request));
            System.out.println(target);
        }



    }

    static class MyController{
        @InitBinder
        public void aaa(WebDataBinder binder){
            binder.addCustomFormatter(new MyDateFormatter("@InitBinder"));
        }
    }

    static class User{
        private Date birthDay;

        private Address address;

        public Date getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(Date birthDay) {
            this.birthDay = birthDay;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "User{" +
                    "birthDay=" + birthDay +
                    ", address=" + address +
                    '}';
        }
    }

    static class Address{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
