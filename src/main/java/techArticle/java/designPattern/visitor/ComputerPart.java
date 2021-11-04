package techArticle.java.designPattern.visitor;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public interface ComputerPart {

    public void accept(ComputerPartVisitor computerPartVisitor);

}
