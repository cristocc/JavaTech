package test;

import org.openjdk.jol.info.ClassLayout;

/**
 * Created by crist on 2021/8/3
 *
 * @author cc
 */
public class ThreadTest implements Runnable {

    private Object o;

    public ThreadTest(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        synchronized (o){
            System.out.println(Thread.currentThread().getName() + "" + ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
