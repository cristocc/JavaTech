package techArticle.java.thread;

/**
 * Created by crist on 2021/6/7
 *
 * @author cc
 */
public class ConsumerYield extends Thread {

    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Consumer : Consumed Item " + i);
            Thread.yield();
        }
    }
}
