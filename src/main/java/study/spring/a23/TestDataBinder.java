package study.spring.a23;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;

import java.util.Date;

public class TestDataBinder {

    public static void main(String[] args) {
        MyBean target = new MyBean();
        DataBinder binder = new DataBinder(target);
        //ServletRequestDataBinder
        //ServletRequestParameterPropertyValues
        //binder.initBeanPropertyAccess();
        MutablePropertyValues pvs = new MutablePropertyValues();
        pvs.add("a","10");
        pvs.add("b","abc");
        pvs.add("c","2023/05/30");
        binder.bind(pvs);
        System.out.println(target);
    }

    static class MyBean{
        private int a;
        private String b;
        private Date c;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public Date getC() {
            return c;
        }

        public void setC(Date c) {
            this.c = c;
        }

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
