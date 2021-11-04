package techArticle.java.designPattern.memento;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class Memento {

    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
