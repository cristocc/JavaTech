package techArticle.algorithm.leetcode.dp;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/longest-palindromic-subsequence/
 * @author cc
 */
public class LeetCode473_makesquare {

    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    int dfs(int[][] grid, int r, int c) {
        if ( r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c) + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
    }



/*    void dfs(int[][] grid, int r, int c) {
    // 若坐标不合法，直接返回
    if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
        return;
    }
    // 若该方格不是岛屿，直接返回
    if (grid[r][c] != 1) {
        return;
    }

        dfs(grid, r - 1, c); // 上边相邻
        dfs(grid, r + 1, c); // 下边相邻
        dfs(grid, r, c - 1); // 左边相邻
        dfs(grid, r, c + 1); // 右边相邻
    }*/

}
