package techArticle.java.designPattern.builder;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class Test {

    public static void main(String[] args){
        Director director = new Director();
        Product product1 = director.getAProduct();
        product1.showProduct();

        Product product2 = director.getBProduct();
        product2.showProduct();
    }
}
