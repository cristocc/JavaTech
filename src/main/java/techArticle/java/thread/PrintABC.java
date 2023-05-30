package techArticle.java.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {

    public static void main(String[] args) throws InterruptedException {
/*        int i = 0;
        Object o = new Object();

        Thread t1 = new Thread(new Print(i,o,"a"),"t1");

        Thread t2 = new Thread(new Print(i,o,"b"),"t2");


        t1.start();
        t2.start();*/

/*        WaitNotify wn = new WaitNotify(1,5);
        new Thread(()->{
            wn.print("a",1,2);
        }).start();
        new Thread(()->{
            wn.print("b",2,3);
        }).start();
        new Thread(()->{
            wn.print("c",3,1);
        }).start();*/

        AwaitSingal awaitSingal = new AwaitSingal(5);
        Condition a = awaitSingal.newCondition();
        Condition b = awaitSingal.newCondition();
        Condition c = awaitSingal.newCondition();

        new Thread(()->{
            awaitSingal.print("a",a,b);
        }).start();
        new Thread(()->{
            awaitSingal.print("b",b,c);
        }).start();
        new Thread(()->{
            awaitSingal.print("c",c,a);
        }).start();
        Thread.sleep(1000);
        awaitSingal.lock();
        a.signal();
        awaitSingal.unlock();

    }

    static class AwaitSingal extends ReentrantLock {
        private int loopNum;

        public AwaitSingal(int loopNum) {
            this.loopNum = loopNum;
        }

        public void print(String s,Condition current,Condition next){
            for(int i = 0;i<loopNum;i++){
                lock();
                try {
                    current.await();
                    System.out.print(s);
                    next.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    unlock();
                }
            }
        }


    }

    static class WaitNotify{

        private int flag;
        private int loopNum;

        public WaitNotify(int flag, int loopNum) {
            this.flag = flag;
            this.loopNum = loopNum;
        }

        public void print(String s, int waitFlag, int nextFlag){
            for (int i = 0 ;i<loopNum;i++){
                synchronized (this){
                    while (flag != waitFlag){
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(s);
                    flag = nextFlag;
                    this.notifyAll();
                }
            }
        }
    }

    static class Print implements Runnable{
        private int i;
        private Object o;
        private String s;


        public Print(int i,Object o,String s){
            this.i = i;
            this.o = o;
            this.s = s;
        }
        @Override
        public void run() {
            synchronized (o){
                while (i < 10){
                    o.notifyAll();
                    System.out.print(s);
                    i++;
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
