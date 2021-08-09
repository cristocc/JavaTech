package study.model;

/**
 * Created by crist on 2021/6/10
 *
 * @author cc
 */
public class DerivedTestBean extends InheritedTestBean {

    public void initialize(){
        System.out.println("DerivedTestBean");
    }

    @Override
    public String toString() {
        return "DerivedTestBean{} " + super.toString();
    }
}
