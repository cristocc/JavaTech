package techArticle.java.designPattern.state;

import java.util.Random;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class HasMoneyState implements State {

    private VendingMachine machine;
    private Random random = new Random();

    public HasMoneyState(VendingMachine machine)
    {
        this.machine = machine;
    }

    @Override
    public void insertMoney()
    {
        System.out.println("您已经投过币了，无需再投....");
    }

    @Override
    public void backMoney()
    {
        System.out.println("退币成功");

    }

    @Override
    public void turnCrank()
    {
        System.out.println("你转动了手柄");

    }

    @Override
    public void dispense()
    {
        throw new IllegalStateException("非法状态！");
    }

}
