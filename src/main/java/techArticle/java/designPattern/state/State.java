package techArticle.java.designPattern.state;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public interface State {

    /**
     * 放钱
     */
    public void insertMoney();
    /**
     * 退钱
     */
    public void backMoney();
    /**
     * 转动曲柄
     */
    public void turnCrank();
    /**
     * 出商品
     */
    public void dispense();

}
