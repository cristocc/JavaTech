package techArticle.java.designPattern.prototype;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

