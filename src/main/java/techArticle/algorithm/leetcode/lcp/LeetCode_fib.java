package techArticle.algorithm.leetcode.lcp;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_fib {


    public int calculate(String s) {
        int x = 1;
        int y = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if('A' == c){
                x = 2 * x + y;
            }else{
                y = 2 * y + x;
            }
        }
        return x + y;

    }
}
