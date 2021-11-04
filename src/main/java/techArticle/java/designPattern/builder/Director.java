package techArticle.java.designPattern.builder;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class Director {

    private Builder builder = new ConcreteBuilder();
    public Product getAProduct(){
        builder.setPart("宝马汽车","X7");
        return builder.getProduct();
    }
    public Product getBProduct(){
        builder.setPart("奥迪汽车","Q5");
        return builder.getProduct();
    }
}
