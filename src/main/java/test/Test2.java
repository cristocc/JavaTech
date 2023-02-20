package test;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.Semaphore;

/**
 * Created by crist on 2022/11/11
 *
 * @author cc
 */
public class Test2 {
    static Object obj = new Object();

    public static void main(String[] args)throws Exception {
/*        System.out.println(VM.current().details());
        Object obj = new Object();
        System.out.println(obj + " 十六进制哈希：" + Integer.toHexString(obj.hashCode()));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());*/

/*        System.out.println(VM.current().details());
        synchronized (obj){
            System.out.println(obj + " 十六进制哈希：" + Integer.toHexString(obj.hashCode()));
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
            System.out.println("-----");
            System.out.println(ClassLayout.parseInstance(Test2.class).toPrintable());
            System.out.println("---Thread--");
            System.out.println(ClassLayout.parseInstance(Thread.currentThread()).toPrintable());
        }*/
        //11010100001011100011100101010

/*        test(1);
        System.out.println("-----");
        test(2);*/

        //testSemaphore();

        //join() 是一个 synchronized 方法，里面调用了 wait() 方法，让持有当前同步锁的线程进入等待状态，也就是主线程。
        // 当子线程执行完毕后，我们从源码中可以看到 JVM 调用了 lock.notify_all(thread) 所以唤醒了主线程继续执行。
        Thread thread = new Thread(() -> {
            System.out.println("thread before");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread after");
        });
        thread.start();
        System.out.println("main begin！");
        thread.join();
        System.out.println("main end！");
/*
        FileInputStream is = new FileInputStream(new File(""));
        FileChannel fc = is.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);*/


    }

    public static void nioCopy()throws Exception{
        FileInputStream fis = new FileInputStream(new File(""));
        FileOutputStream fos = new FileOutputStream(new File(""));

        FileChannel readChannel = fis.getChannel();
        FileChannel writeChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true){
            buffer.clear();
            int len = readChannel.read(buffer);
            if(-1 == len){
                break;
            }
            buffer.flip();
            writeChannel.write(buffer);
        }
        fis.close();
        fos.close();

    }

    private static void test(int c){
        if(!tryAcquire(c) && acquireQueued(c)){
            System.out.println("if block");
        }else{
            System.out.println("else block");
        }
    }

    private static boolean tryAcquire(int c){
        if(1 == c){
            System.out.println("tryAcquire c == 1");
            return true;
        }else {
            System.out.println("tryAcquire c != 1");
            return false;
        }
    }

    private static boolean acquireQueued(int c){
        if(1 == c){
            System.out.println("acquireQueued c == 1");
            return true;
        }else {
            System.out.println("acquireQueued c != 1");
            return false;
        }
    }

    private static void testSemaphore(){
        Semaphore semaphore = new Semaphore(2, false); // 构造函数入参，permits：信号量、fair：公平锁/非公平锁
        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "蹲坑");
                    Thread.sleep(1000L);
                } catch (InterruptedException ignore) {
                } finally {
                    semaphore.release();
                }
            }, "蹲坑编号：" + i).start();
        }
    }
/*    64 bits:
            --------
    unused:25 hash:31 -->| unused:1   age:4    biased_lock:1 lock:2 (normal object)
    JavaThread*:54 epoch:2 unused:1   age:4    biased_lock:1 lock:2 (biased object)
    PromotedObject*:61 --------------------->| promo_bits:3 ----->| (CMS promoted object)
    size:64 ----------------------------------------------------->| (CMS free block)

    unused:25 hash:31 -->| cms_free:1 age:4    biased_lock:1 lock:2 (COOPs && normal object)
    JavaThread*:54 epoch:2 cms_free:1 age:4    biased_lock:1 lock:2 (COOPs && biased object)
    narrowOop:32 unused:24 cms_free:1 unused:4 promo_bits:3 ----->| (COOPs && CMS promoted object)
    unused:21 size:35 -->| cms_free:1 unused:7 ------------------>| (COOPs && CMS free block)*/
}
