package techArticle.java.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/5/24
 *
 * @author cc
 */
public class ProducerConsumerTest {

    public static void main(String[] args)
    {
        List<Integer> taskQueue = new ArrayList<Integer>();
        int MAX_CAPACITY = 5;
        Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
        Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
        tProducer.start();
        tConsumer.start();
    }
}
