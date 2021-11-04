package techArticle.java.designPattern.template;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class QAWorker extends Worker{
    public QAWorker(String name)
    {
        super(name);
    }

    @Override
    public void work()
    {
        System.out.println(name + "写测试用例-提交bug-写测试用例");
    }

}
