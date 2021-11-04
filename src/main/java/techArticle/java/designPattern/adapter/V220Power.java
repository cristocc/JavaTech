package techArticle.java.designPattern.adapter;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class V220Power {
    /**
     * 提供220V电压
     *
     * @return
     */
    public int provideV220Power() {
        System.out.println("我提供220V交流电压。");
        return 220;
    }

}
