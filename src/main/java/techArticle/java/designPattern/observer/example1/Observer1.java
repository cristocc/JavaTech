package techArticle.java.designPattern.observer.example1;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class Observer1 implements Observer {

    private Subject subject;

    public Observer1(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("observer1 得到 3D 号码  -->" + msg + ", 我要记下来。");

    }
}