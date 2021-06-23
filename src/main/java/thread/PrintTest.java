package thread;

/**
 * Created by crist on 2021/5/24
 *
 * @author cc
 */
public class PrintTest {
    private final static Object monitor = new Object();
    private static int times = 0;

    public static void main(String[] args)throws Exception {
        synchronized (monitor){
            System.out.println("test");
        }
    }

    }
