package thread;

/**
 * Created by crist on 2021/6/7
 *
 * @author cc
 */
public class YieldTest {

    public static void main(String[] args)
    {
        Thread producer = new ProducerYield();
        Thread consumer = new ConsumerYield();

        producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
        consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

        producer.start();
        consumer.start();
    }

}
