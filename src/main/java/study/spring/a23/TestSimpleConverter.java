package study.spring.a23;


import org.springframework.beans.SimpleTypeConverter;

import java.util.Date;

public class TestSimpleConverter {

    public static void main(String[] args) {
        SimpleTypeConverter con = new SimpleTypeConverter();
        Integer num = con.convertIfNecessary("100",int.class);
        System.out.println(num);
        System.out.println(con.convertIfNecessary("2023/05/30", Date.class));

    }
}
