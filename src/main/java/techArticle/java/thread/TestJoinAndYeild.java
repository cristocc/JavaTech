package techArticle.java.thread;

/**
 * Created by crist on 2021/5/24
 *
 * @author cc
 */
public class TestJoinAndYeild {

    //join() method suspends the execution of the calling thread until the object called finishes its execution.
    public static void main(String[] args)throws Exception {
        TestJoinAndYeild t1 = new TestJoinAndYeild();
        t1.test1();
        //test1();
        //test2();
    }

    private  void test1()throws Exception{
        //thread t1 start
        //sleep 2second start
        //sleep 2second end
        // thread t2 start
        Thread t1 = new Thread(() ->{
            System.out.println("thread t1 start");
            System.out.println("sleep 2 second start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleep 2 second end");
        });
        Thread t2 = new Thread(() ->{
            System.out.println("thread t2 start");
        });
        t1.start();
        t1.wait();
        t2.start();
    }

    private static void test2()throws Exception{
        //thread t1 start
        //sleep 2second start
        //sleep 2second end
       // thread t2 start
        Object obj = new Object();
        Thread t1 = new Thread(() ->{
            synchronized (obj) {
                System.out.println("thread t1 start");
                System.out.println("sleep 2second start");
                try {
                    Thread.sleep(2000);
                    System.out.println("sleep 2second end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() ->{
            synchronized (obj) {
                try {
                    System.out.println("thread t2 start");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }

}
