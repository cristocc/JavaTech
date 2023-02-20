package techArticle.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/combination-sum/
 * @author cc
 */
public class LeetCode_generateParenthesis {
    List<String> ans = new ArrayList<String>();
    StringBuilder cur = new StringBuilder();

    public List<String> generateParenthesis(int n) {

        backtrack( 0, 0, n);
        return ans;
    }

    public void backtrack( int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack( open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
