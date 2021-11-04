package techArticle.java.designPattern.adapter;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class Test {

    public static void main(String[] args)
    {
        Mobile mobile = new Mobile();
        V5Power v5Power = new V5PowerAdapter(new V220Power()) ;
        mobile.inputPower(v5Power);
    }

}
