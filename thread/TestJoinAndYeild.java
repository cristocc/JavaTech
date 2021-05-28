package thread;

/**
 * Created by crist on 2021/5/24
 *
 * @author cc
 */
public class TestJoinAndYeild {

    public static void main(String[] args)throws Exception {
        Thread t1 = new Thread(() ->{
            System.out.println("thread t1 start");
            System.out.println("sleep 2second start");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleep 2second end");
        });
        Thread t2 = new Thread(() ->{
            System.out.println("thread t2 start");
        });

        t1.start();
        t1.join();
        t2.start();
    }
}
