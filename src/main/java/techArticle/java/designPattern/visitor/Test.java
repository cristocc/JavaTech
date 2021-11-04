package techArticle.java.designPattern.visitor;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class Test {

    public static void main(String[] args) {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
