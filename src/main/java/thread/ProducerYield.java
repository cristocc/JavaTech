package thread;

/**
 * Created by crist on 2021/6/7
 *
 * @author cc
 */
public class ProducerYield extends Thread{

    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Producer : Produced Item " + i);
            Thread.yield();
        }
    }
}
