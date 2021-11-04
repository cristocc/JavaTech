package techArticle.java.designPattern.chain;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class FileLogger extends AbstractLogger{

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
