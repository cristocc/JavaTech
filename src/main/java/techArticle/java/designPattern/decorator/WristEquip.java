package techArticle.java.designPattern.decorator;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class WristEquip implements IEquip {

    @Override
    public int caculateAttack()
    {
        return 5;
    }

    @Override
    public String description()
    {
        return "圣战护腕";
    }


}
