package techArticle.java.designPattern.builder;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class Product {

    private String name;
    private String type;
    public void showProduct(){
        System.out.println("名称："+name);
        System.out.println("型号："+type);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
}
