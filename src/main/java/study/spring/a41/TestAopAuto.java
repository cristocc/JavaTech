package study.spring.a41;

import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Annotation;
import java.util.List;

public class TestAopAuto {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        StandardEnvironment env = new StandardEnvironment();
        //env.getPropertySources().addLast(new SimpleCommandLinePropertySource("--spring.aop.auto=false"));
        //env.getPropertySources().addLast(new SimpleCommandLinePropertySource("--spring.aop.proxy-target-class=false"));
        context.setEnvironment(env);
        AnnotationConfigUtils.registerAnnotationConfigProcessors(context.getDefaultListableBeanFactory());
        context.registerBean(Config.class);
        context.refresh();
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

    }

    static class MyImportSelector implements DeferredImportSelector {

        @Override
        public String[] selectImports(AnnotationMetadata importingClassMetadata) {
/*            List<String> names = SpringFactoriesLoader.loadFactoryNames(AopAutoConfiguration.class,null);
            return names.toArray(new String[0]);*/
            return new String[]{AopAutoConfiguration.class.getName()};
        }
    }

    @Configuration
    @Import(MyImportSelector.class)
    static class Config{

    }
}
