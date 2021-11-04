package techArticle.java.designPattern.builder;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class ConcreteBuilder extends Builder {

    private Product product = new Product();

    public Product getProduct() {
        return product;
    }

    public void setPart(String arg1, String arg2) {
        product.setName(arg1);
        product.setType(arg2);
    }
}
