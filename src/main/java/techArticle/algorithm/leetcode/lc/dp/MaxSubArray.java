package techArticle.algorithm.leetcode.lc.dp;

/**
 * Created by crist on 2022/7/27
 *
 * @author cc
 */
public class MaxSubArray {

    //用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2])% 1000000007;
        }
        return dp[n];

    }
}
