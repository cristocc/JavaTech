package techArticle.java.designPattern.visitor;



/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public interface ComputerPartVisitor {

    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
}
