package techArticle.java.designPattern.decorator;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public interface IEquip {

    /**
     * 计算攻击力
     *
     * @return
     */
    public int caculateAttack();

    /**
     * 装备的描述
     *
     * @return
     */
    public String description();

}
