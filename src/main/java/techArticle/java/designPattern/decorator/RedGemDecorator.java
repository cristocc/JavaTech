package techArticle.java.designPattern.decorator;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class RedGemDecorator implements IEquipDecorator {

    /**
     * 每个装饰品维护一个装备
     */
    private IEquip equip;

    public RedGemDecorator(IEquip equip)
    {
        this.equip = equip;
    }

    @Override
    public int caculateAttack()
    {
        return 15 + equip.caculateAttack();
    }

    @Override
    public String description()
    {
        return equip.description() + "+ 红宝石";
    }


}
