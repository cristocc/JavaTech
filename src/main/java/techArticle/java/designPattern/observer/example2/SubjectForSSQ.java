package techArticle.java.designPattern.observer.example2;

import java.util.Observable;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class SubjectForSSQ extends Observable {

    private String msg;


    public String getMsg() {
        return msg;
    }


    /**
     * 主题更新消息
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
        setChanged();
        notifyObservers();
    }

}
