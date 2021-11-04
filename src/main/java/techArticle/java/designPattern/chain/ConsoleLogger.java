package techArticle.java.designPattern.chain;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
