package techArticle.java;

import java.io.Serializable;

/**
 * Created by crist on 2021/6/1
 *
 * @author cc
 */
public class ClassLoderTest   {


    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("--");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("--");
        System.out.println(System.getProperty("java.class.path"));
    }
}
