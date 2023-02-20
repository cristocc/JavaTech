package study.aop;

import org.springframework.stereotype.Component;

import java.nio.channels.Channels;

/**
 * Created by crist on 2022/10/31
 *
 * @author cc
 */
@Component
public class TestBean {

    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {

    }
}
