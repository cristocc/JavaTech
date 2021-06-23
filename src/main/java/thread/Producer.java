package thread;

import java.util.List;

/**
 * Created by crist on 2021/5/24
 *
 * @author cc
 */
public class Producer implements Runnable {

    private final List<Integer> taskQueue;

    private final int MAX_CAPACITY;

    public Producer(List<Integer> taskQueue, int MAX_CAPACITY) {
        this.taskQueue = taskQueue;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                produce(counter++);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.size() == MAX_CAPACITY) {
                System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                taskQueue.wait();
            }

            Thread.sleep(1000);
            taskQueue.add(i);
            System.out.println("Produced: " + i);
            taskQueue.notifyAll();
        }
    }
}
