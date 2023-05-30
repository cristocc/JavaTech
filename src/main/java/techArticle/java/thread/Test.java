package techArticle.java.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
/*        demo(
                ()->new int[10],
                (array)->array.length,
                (array,index)->array[index]++,
                (array)->System.out.println(Arrays.toString(array))
        );
        List list = new ArrayList();
        list.add(1);
        demo1(
                ()-> list,
                (list1)->list1.size()
        );

        LongAdder a = new LongAdder();*/

        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe)theUnsafe.get(null);
        System.out.println(unsafe);


    }

    private static <T> void demo1(Supplier<T> arraySupplier,Function<T,Integer> lengthFun){
        T array = arraySupplier.get();
        int length = lengthFun.apply(array);
        System.out.println(length);
    }

    private static <T> void demo(
            Supplier<T> arraySupplier,
            Function<T,Integer> lengthFun,
            BiConsumer<T,Integer> putConsumer,
            java.util.function.Consumer<T> printConsumer){
        List<Thread> ts = new ArrayList<>();
        T array = arraySupplier.get();
        int length = lengthFun.apply(array);
        for(int i =0;i<length;i++){
            ts.add(new Thread(()->{
                for(int j=0;j<1000;j++){
                    putConsumer.accept(array,j%length);
                }
            }));
        }
        ts.forEach(t ->t.start());
        ts.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        printConsumer.accept(array);
    }
}
