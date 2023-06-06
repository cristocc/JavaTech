package study.spring.a10;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    final public void foo(){
        System.out.println("foo");
        bar();
    }

    public void bar(){
        System.out.println("bar");
    }
}
