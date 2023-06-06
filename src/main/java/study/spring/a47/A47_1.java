package study.spring.a47;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Optional;

@Configuration
public class A47_1 {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(A47_1.class);
        DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();


/*        {
            //bean2
            DependencyDescriptor dd1 = new DependencyDescriptor(Bean1.class.getDeclaredField("bean2"),false);
            Object bean2 = beanFactory.doResolveDependency(dd1,"bean1",null,null);
            System.out.println(bean2);
        }*/

/*        {
            //setBean2
            Method method = Bean1.class.getDeclaredMethod("setBean2", Bean2.class);
            DependencyDescriptor dd2 = new DependencyDescriptor(new MethodParameter(method,0),false);
            System.out.println(beanFactory.doResolveDependency(dd2,"bean1",null,null));
        }*/

/*        {
            //Optional<Bean2>
            DependencyDescriptor dd3 = new DependencyDescriptor(Bean1.class.getDeclaredField("bean3"),false);
            //System.out.println(dd3.getDependencyType());
            if(dd3.getDependencyType() == Optional.class){
                dd3.increaseNestingLevel();
                //System.out.println(dd3.getDependencyType());
                Object result = beanFactory.doResolveDependency(dd3,"bean1",null,null);
                Optional.ofNullable(result);
            }
        }*/

/*        {
            //ObjectFactory<Bean2>
            DependencyDescriptor dd4 = new DependencyDescriptor(Bean1.class.getDeclaredField("bean4"),false);
            if(dd4.getDependencyType() == ObjectFactory.class){
                dd4.increaseNestingLevel();
                //System.out.println(dd3.getDependencyType());

                ObjectFactory objectFactory = new ObjectFactory() {
                    @Override
                    public Object getObject() throws BeansException {
                        Object result = beanFactory.doResolveDependency(dd4,"bean1",null,null);
                        return result;
                    }
                };

                System.out.println(objectFactory.getObject());
            }
        }*/

        {
            // lazy
            DependencyDescriptor dd5 = new DependencyDescriptor(Bean1.class.getDeclaredField("bean2"),false);
            ContextAnnotationAutowireCandidateResolver resolver = new ContextAnnotationAutowireCandidateResolver();
            resolver.setBeanFactory(beanFactory);
            Object proxy = resolver.getLazyResolutionProxyIfNecessary(dd5,"bean1");
            System.out.println(proxy);
            System.out.println(proxy.getClass());

            while (true){

            }
        }


    }

    static class Bean1{
        @Autowired
        @Lazy
        private Bean2 bean2;

        @Autowired
        public void setBean2( Bean2 bean2){
            this.bean2 = bean2;
        }

        @Autowired
        private Optional<Bean2> bean3;

        @Autowired
        private ObjectFactory<Bean2> bean4;

    }

    @Component("bean2")
    static class Bean2{

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
