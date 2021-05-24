package thread;

/**
 * Created by crist on 2021/5/24
 *
 * @author cc
 */
public class PrintAB {
    private final static Object monitor = new Object();
    private static int times = 0;

    public static void main(String[] args)throws Exception {
        Runnable a = () -> {
            print("a");
        };
        Runnable b = () -> {
            print("b");
        };
        new Thread(a).start();
        Thread.sleep(1);
        new Thread(b).start();
    }

    private static void print(String data){
        synchronized (monitor){
            try {
                while (times<10){
                    monitor.notifyAll();
                    System.out.println(data);
                    times++;
                    monitor.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
