package techArticle.algorithm.bin;

/**
 * Created by crist on 2022/6/6
 *
 * @author cc
 */
public class Test {

    public static void main(String[] args) {
        int num = -3;
        for(int i=31;i>=0;i--){
            System.out.print( (num &(1<<i)) == 0?"0":"1");
        }
        System.out.println();
        num = 3;
        for(int i=31;i>=0;i--){
            System.out.print( (num &(1<<i)) == 0?"0":"1");
        }
    }
}
