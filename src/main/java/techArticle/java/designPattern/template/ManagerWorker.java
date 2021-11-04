package techArticle.java.designPattern.template;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class ManagerWorker extends Worker{
    public ManagerWorker(String name)
    {
        super(name);
    }

    @Override
    public void work()
    {
        System.out.println(name + "打dota...");
    }

}
