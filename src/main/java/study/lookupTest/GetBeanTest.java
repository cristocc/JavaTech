package study.lookupTest;

/**
 * Created by crist on 2022/9/26
 *
 * @author cc
 */
public abstract class GetBeanTest {

    public abstract User getBean();

    public void showMe(){
        getBean().showMe();
    }
}
