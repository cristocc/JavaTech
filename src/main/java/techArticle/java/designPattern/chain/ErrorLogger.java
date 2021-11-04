package techArticle.java.designPattern.chain;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
