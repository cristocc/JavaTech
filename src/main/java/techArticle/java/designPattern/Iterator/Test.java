package techArticle.java.designPattern.Iterator;

/**
 * Created by crist on 2021/11/4
 *
 * @author cc
 */
public class Test {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }

}
