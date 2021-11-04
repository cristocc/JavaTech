package techArticle.java.designPattern.observer.example1;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public interface Subject {

    /**
     * 注册一个观察着
     *
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除一个观察者
     *
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有的观察着
     */
    void notifyObservers();


}
