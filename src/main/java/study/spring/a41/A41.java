package study.spring.a41;

import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;

public class A41 {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("config",Config.class);
        context.registerBean(ConfigurationClassPostProcessor.class);
        context.refresh();

        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        context.close();

    }

    static class MyImportSelector implements ImportSelector{

        @Override
        public String[] selectImports(AnnotationMetadata importingClassMetadata) {
            List<String> names = SpringFactoriesLoader.loadFactoryNames(MyImportSelector.class,null);
            return names.toArray(new String[0]);
        }
    }

    @Configuration
    @Import(MyImportSelector.class)
    static class Config{

    }

    @Configuration
    static class AutoConfiguration1{
        @Bean
        public Bean1 bean1(){
            return new Bean1();
        }
    }

    @Configuration
    static class AutoConfiguration2{
        @Bean
        public Bean2 bean2(){
            return new Bean2();
        }
    }

    static class Bean1{

    }

    static class Bean2{

    }
}
