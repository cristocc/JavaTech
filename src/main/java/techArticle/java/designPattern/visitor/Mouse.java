package techArticle.java.designPattern.visitor;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
