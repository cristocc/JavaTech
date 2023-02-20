package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/dungeon-game/
 * @author cc
 */
public class LeetCode647_countSubstrings {

    // 备忘录，消除重叠子问题
    int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // 备忘录中都初始化为 -1
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // 我们想计算左上角到右下角所需的最小生命值
        return dp(dungeon, 0, 0);
    }

    int dp(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        // base case
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }
        // 避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 状态转移逻辑
        int res = Math.min(dp(grid, i, j + 1), dp(grid, i + 1, j)) - grid[i][j];
        // 骑士的生命值至少为 1
        memo[i][j] = res <= 0 ? 1 : res;
        return memo[i][j];
    }
}
