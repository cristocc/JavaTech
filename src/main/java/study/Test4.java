package study;

/**
 * Created by crist on 2022/11/29
 *
 * @author cc
 */
public class Test4 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Test4 t = new Test4();
        t.m2();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public void m1(){
        String temp ;
        for(int i = 0;i < 100000000;i++){
            temp = "aa";
        }

    }
    public void m2(){
        String temp ;
        for(int i = 0;i < 100000000;i++){
            temp = a;
        }
    }

    private static int ta = 0;

    private static String a = "aa";
}
