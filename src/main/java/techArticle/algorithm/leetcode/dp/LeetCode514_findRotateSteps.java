package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/freedom-trail/
 * @author cc
 */
public class LeetCode514_findRotateSteps {

    // 字符 -> 索引列表
    HashMap<Character, List<Integer>> charToIndex = new HashMap<>();
    // 备忘录
    int[][] memo;

    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        // 备忘录全部初始化为 0
        memo = new int[m][n];
        // 记录圆环上字符到索引的映射
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            if (!charToIndex.containsKey(c)) {
                charToIndex.put(c, new LinkedList<>());
            }
            charToIndex.get(c).add(i);
        }
        // 圆盘指针最初指向 12 点钟方向，
        // 从第一个字符开始输入 key
        return dp(ring, 0, key, 0);
    }

    int dp(String ring, int i, String key, int j) {
        // base case 完成输入
        if (j == key.length()){
            return 0;
        }
        // 查找备忘录，避免重叠子问题
        if (memo[i][j] != 0){
            return memo[i][j];
        }
        int n = ring.length();
        // 做选择
        int res = Integer.MAX_VALUE;
        // ring 上可能有多个字符 key[j]
        List<Integer> chars = charToIndex.get(key.charAt(j));
        for (int k : chars) {
            // 拨动指针的次数
            int delta = Math.abs(k - i);
            // 选择顺时针还是逆时针
            delta = Math.min(delta, n - delta);
            // 将指针拨到 ring[k]，继续输入 key[j+1..]
            int subProblem = dp(ring, k, key, j + 1);
            // 选择「整体」操作次数最少的
            // 加一是因为按动按钮也是一次操作
            res = Math.min(res, 1 + delta + subProblem);
        }
        // 将结果存入备忘录
        memo[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        LeetCode514_findRotateSteps test = new LeetCode514_findRotateSteps();
        test.findRotateSteps("godding","gd");
/*        for(int [] a:test.memo){
            System.out.print(a[0]+" " + a[1]);
            System.out.println();
        }*/
    }
}
