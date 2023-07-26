package study.cacheLine;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class Cache2 {

    private static class Padding {
        private volatile long p1,p2,p3,p4,p5,p6,p7;
        //private volatile long p1,p2,p3,p4;
    }
    private static class T extends Padding{
        private volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        //14517

        //System.out.println(VM.current().details());
        System.out.println(arr[0] + " 十六进制哈希：" + Integer.toHexString(arr[0].hashCode()));
        System.out.println(ClassLayout.parseInstance(arr[0]).toPrintable());
        Thread t1 = new Thread(() ->{
            for(long i =0 ;i< Integer.MAX_VALUE;i++){
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(() ->{
            for(long i =0 ;i< Integer.MAX_VALUE;i++){
                arr[1].x = i;
            }
        });

        long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start)/ 100_0000);

    }
}
