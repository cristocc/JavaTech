package techArticle.java.designPattern.builder;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public abstract class Builder {
    public abstract void setPart(String arg1, String arg2);
    public abstract Product getProduct();
}
