package test;

import org.openjdk.jol.info.ClassLayout;

/**
 * Created by crist on 2021/8/3
 *
 * @author cc
 */
public class Test1 {

    private static Object o;

    public static void main(String[] args)throws Exception {
        o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("---------加锁后的变化");
        Thread.sleep(1000);
        System.out.println("---------无竞争加锁后的变化");
        synchronized (o){
            System.out.println(Thread.currentThread().getName() + "" + ClassLayout.parseInstance(o).toPrintable());
        }
        Thread.sleep(1000);
        new Thread(new ThreadTest(o)).start();
        new Thread(new ThreadTest(o)).start();
        Thread.sleep(1000);
        System.out.println("---------无锁后的变化");
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
