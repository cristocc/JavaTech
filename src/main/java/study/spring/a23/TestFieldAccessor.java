package study.spring.a23;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.DirectFieldAccessor;

import java.util.Date;

public class TestFieldAccessor {

    public static void main(String[] args) {
        MyBean target = new MyBean();
        DirectFieldAccessor accessor = new DirectFieldAccessor(target);
        accessor.setPropertyValue("a","10");
        accessor.setPropertyValue("b","abc");
        accessor.setPropertyValue("c","2023/05/30");
        System.out.println(target);

    }

    static class MyBean{
        private int a;
        private String b;
        private Date c;

        @Override
        public String toString() {
            return "MyBean{" +
                    "a=" + a +
                    ", b='" + b + '\'' +
                    ", c=" + c +
                    '}';
        }
    }
}
