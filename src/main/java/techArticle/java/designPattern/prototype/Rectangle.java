package techArticle.java.designPattern.prototype;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

