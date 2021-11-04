package techArticle.java.designPattern.template;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class ITWorker extends Worker{

    public ITWorker(String name)
    {
        super(name);
    }

    @Override
    public void work()
    {
        System.out.println(name + "写程序-测bug-fix bug");
    }

}
