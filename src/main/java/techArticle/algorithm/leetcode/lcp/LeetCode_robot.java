package techArticle.algorithm.leetcode.lcp;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_robot {

    public static int minCount(int[] coins) {
        int ans = 0;

        for(int c:coins){
                if(c % 2 == 0){
                    ans = ans + c/2;
                }else {
                    ans = ans + c/2 + 1;
                }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] coins = {2,3,10};
        minCount(coins);
    }
}
