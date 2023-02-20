package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/cheapest-flights-within-k-stops/
 * @author cc
 */
public class LeetCode787_findCheapestPrice {

    // 哈希表记录每个点的入度
    // to -> [from, price]
    HashMap<Integer, List<int[]>> indegree;
    int src, dst;
    // 备忘录
    int[][] memo;

  //  现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，
    //  使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 将中转站个数转化成边的条数
        K++;
        this.src = src;
        this.dst = dst;
        memo = new int[n][K + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -888);
        }

        indegree = new HashMap<>();
        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            // 记录谁指向该节点，以及之间的权重
            indegree.putIfAbsent(to, new LinkedList<>());
            indegree.get(to).add(new int[] {from, price});
        }
        return dp(dst, K);
    }

    int dp(int s, int k) {
        // base case
        if (s == src) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        // 查备忘录，防止冗余计算
        if (memo[s][k] != -888) {
            return memo[s][k];
        }
        // 初始化为最大值，方便等会取最小值
        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)) {
            // 当 s 有入度节点时，分解为子问题
            for (int[] v : indegree.get(s)) {
                int from = v[0];
                int price = v[1];
                // 从 src 到达相邻的入度节点所需的最短路径权重
                int subProblem = dp(from, k - 1);
                // 跳过无解的情况
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        // 如果还是初始值，说明此节点不可达
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }

    public static void main(String[] args) {
        LeetCode787_findCheapestPrice test = new LeetCode787_findCheapestPrice();
        int n = 3;
        int src = 0;
        int dst = 2;
        int k = 1;
        int [][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(test.findCheapestPrice(n,flights,src,dst,k));
    }

}
