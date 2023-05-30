package techArticle.java.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        System.out.println(pool.invoke(new MyTask(5)));
    }
}


class AddTask3 extends RecursiveTask<Integer>{

    private int begin;
    private int end;

    public AddTask3(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(begin == end){
            return begin;
        }
        if(end - begin == 1){
            return begin + end;
        }
        int mid = (end + begin) / 2;
        AddTask3 t1 = new AddTask3(begin,mid);
        t1.fork();
        AddTask3 t2 = new AddTask3(mid+1,end);
        t2.fork();
        int result = t1.join() + t2.join();
        return result;
    }
}

class MyTask extends RecursiveTask<Integer>{

    private int n;

    public MyTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if(n == 1){
            return 1;
        }
        MyTask t1 = new MyTask(n - 1);
        t1.fork();
        return n + t1.join();
    }
}
