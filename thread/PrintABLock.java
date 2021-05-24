package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by crist on 2021/5/24
 *
 * @author cc
 */
public class PrintABLock {
    private static volatile int times = 10;

    public static void main(String[] args)throws Exception {

        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Runnable a = ()->{
            print(lock,"A",conditionA,conditionB);
        };
        Runnable b = ()->{
            print(lock,"b",conditionB,conditionA);
        };

        new Thread(a).start();
        Thread.sleep(1);
        new Thread(b).start();
    }

    private static void print(Lock lock,String data,Condition thisCondition,Condition nextCondition){
        try {
            lock.lock();
            for (int i = 0; i < times; i++) {
                nextCondition.signal();
                System.out.println(data);
                thisCondition.await();
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            lock.unlock();
        }

    }

}
