package techArticle.algorithm.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
//https://leetcode-cn.com/problems/permutations-ii/
public class Leetcode1079 {

    boolean[] vis;
    int count = 0;

    public int numTilePossibilities(String tiles) {
        char[] s = tiles.toCharArray();
        vis = new boolean[s.length];
        Arrays.sort(s);
        dfs(s);
        return count;
    }

    private void dfs(char[] candidates) {
        char last = '*';
        for (int i = 0; i < candidates.length; i++) {
            if (!vis[i] && candidates[i] != last) {
                count++;
                vis[i] = true;
                dfs(candidates);
                vis[i] = false;
                last = candidates[i];
            }
        }
    }

}
