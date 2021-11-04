package techArticle.java.designPattern.interpreter;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}
