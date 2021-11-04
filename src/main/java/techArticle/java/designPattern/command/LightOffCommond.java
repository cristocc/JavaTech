package techArticle.java.designPattern.command;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class LightOffCommond implements Command {

    private Light light ;

    public LightOffCommond(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute()
    {
        light.off();
    }

}
