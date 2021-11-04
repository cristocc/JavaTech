package techArticle.java.designPattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
