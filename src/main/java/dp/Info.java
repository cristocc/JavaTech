package dp;

/**
 * Created by crist on 2020/11/23
 *
 * @author cc
 */
public class Info {
    //dp
    class Version2{
        /*3、dp 数组的迭代解法
            有了上一步「备忘录」的启发，我们可以把这个「备忘录」独立出来成为一张表，就叫做 DP table 吧，在这张表上完成「自底向上」的推算岂不美哉！*/
        int fib(int N) {
            if (N == 0) return 0;

            int[] dp = new int[N];
            // base case
            dp[1] = dp[2] = 1;
            for (int i = 3; i <= N; i++)
                dp[i] = dp[i - 1] + dp[i - 2];
            return dp[N-1];
        }
    }

    class Version1 {
/*
        2、带备忘录的递归解法
        明确了问题，其实就已经把问题解决了一半。即然耗时的原因是重复计算，那么我们可以造一个「备忘录」，每次算出某个子问题的答案后别急着返回，先记到「备忘录」里再返回；每次遇到一个子问题先去「备忘录」里查一查，如果发现之前已经解决过这个问题了，直接把答案拿出来用，不要再耗时去计算了。
        一般使用一个数组充当这个「备忘录」，当然你也可以使用哈希表（字典），思想都是一样的。*/
        int fib(int N) {
            if (N < 1) return 0;
            // 备忘录全初始化为 0
            int[] memo = new int[N];
            // 进行带备忘录的递归
            return helper(memo, N);
        }

        int helper(int[] memo, int n) {
            // base case
            if (n == 1 || n == 2) return 1;
            // 已经计算过
            if (memo[n] != 0) return memo[n];
            memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
            return memo[n];
        }
    }
}
