package techArticle.java.designPattern.bridge;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class Test {

    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
