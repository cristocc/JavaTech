package study.spring.a33;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;


public class A33 {

    public static void main(String[] args) throws Exception {
        AnnotationConfigServletWebServerApplicationContext context =
                new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);


    }
}
