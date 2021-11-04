package techArticle.java.designPattern.bridge;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
