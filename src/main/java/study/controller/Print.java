package study.controller;

/**
 * Created by crist on 2021/5/24
 *
 * @author cc
 */
public class Print  {

    public static Object monitor = new Object();
    public static int times = 0;

    public static void main(String[] args) throws Exception {

        Runnable a = () ->{
            while(times<10) {
                synchronized (monitor) {
                    try {
                        monitor.notifyAll();
                        System.out.println("A");
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                times++;
            }
        };
        Runnable b = () ->{
            while(times<10) {
                synchronized (monitor) {
                    try {
                        monitor.notifyAll();
                        System.out.println("B");
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                times++;
            }
        };

        new Thread(a).start();
        Thread.sleep(1);
        new Thread(b).start();
    }
}
