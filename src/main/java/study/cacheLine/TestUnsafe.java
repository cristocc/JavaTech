package study.cacheLine;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe {


    //private static byte[] bytes = new byte[1024 * 1024];

    public static void main(String[] args) throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe)theUnsafe.get(null);
        System.out.println(unsafe);

        long   base = unsafe.allocateMemory(1024  );
        System.out.println(base);
        unsafe.setMemory(base, 1024, (byte) 'a');

        System.out.println(unsafe.getByte(base));
        System.out.println(unsafe.getByte(base+1));

        System.out.println(unsafe.getByte(base+1028));
        unsafe.freeMemory(base);



    }
}
