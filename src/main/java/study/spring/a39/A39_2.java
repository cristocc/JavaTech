package study.spring.a39;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.*;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

@Configuration
public class A39_2 {

    public static void main(String[] args) throws Exception {


        SpringApplication app = new SpringApplication(A39_2.class);
        app.addInitializers(applicationContext -> System.out.println("Initializers invoke" + applicationContext));
        System.out.println(">>>>>>>>>>>>>>>>2.封装启动args");
        DefaultApplicationArguments arguments = new DefaultApplicationArguments(args);

        System.out.println(">>>>>>>>>>>>>>>>8.创建spring容器");
        GenericApplicationContext context = createApplicationContext(WebApplicationType.SERVLET);
        System.out.println(">>>>>>>>>>>>>>>>9.准备容器");
        for (ApplicationContextInitializer initializer : app.getInitializers()) {
            initializer.initialize(context);
        }
        System.out.println(">>>>>>>>>>>>>>>>10.加载bean定义");
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context.getDefaultListableBeanFactory());
        reader.register(Config.class);
/*        XmlBeanDefinitionReader reader1 = new XmlBeanDefinitionReader(context.getDefaultListableBeanFactory());
        reader1.loadBeanDefinitions()*/
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context.getDefaultListableBeanFactory());
        scanner.scan("study.spring.a39.sub");

        context.refresh();
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name+":"+context.getBeanFactory().getBeanDefinition(name).getResourceDescription());

        }

        System.out.println(">>>>>>>>>>>>>>>>12.执行runner");
        for (CommandLineRunner runner : context.getBeansOfType(CommandLineRunner.class).values()) {
            runner.run(args);
        }

        for (ApplicationRunner runner : context.getBeansOfType(ApplicationRunner.class).values()) {
            runner.run(arguments);
        }


        context.close();
    }


    public static GenericApplicationContext createApplicationContext(WebApplicationType type) {
        GenericApplicationContext context = null;
        switch (type) {
            case SERVLET:
                context = new AnnotationConfigServletWebServerApplicationContext();
                break;
            case REACTIVE:
                context = new AnnotationConfigReactiveWebServerApplicationContext();
                break;
            default:
                context = new AnnotationConfigApplicationContext();
        }
        return context;
    }


    static class Bean5{

    }
    @Configuration
    static class Config{
        @Bean
        public Bean5 bean5(){
            return new Bean5();
        }

        @Bean
        public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
            return new TomcatServletWebServerFactory();
        }

        @Bean
        public CommandLineRunner commandLineRunner(){
            return new CommandLineRunner() {
                @Override
                public void run(String... args) throws Exception {
                    System.out.println("commandLineRunner..." + Arrays.toString(args));
                }
            };
        }

        @Bean
        public ApplicationRunner applicationRunner(){
            return new ApplicationRunner() {
                @Override
                public void run(ApplicationArguments args) throws Exception {
                    System.out.println("applicationRunner..." + Arrays.toString(args.getSourceArgs()));
                    System.out.println(args.getOptionNames());
                    System.out.println(args.getOptionValues("server.port"));
                }
            };
        }
    }




}
