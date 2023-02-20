package techArticle.algorithm.leetcode.lc.dp;

/**
 * Created by crist on 2022/7/27
 *
 * @author cc
 */
public class TranslateNum {

/*   输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"*/

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = dp[1] = 1;
        for(int i =2;i<=len;i++){
            String c = s.substring(i-2,i);
            if(Integer.valueOf(c) >= 10 && Integer.valueOf(c) <= 25){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        TranslateNum sum = new TranslateNum();
        sum.translateNum(624);
    }

}
