package techArticle.algorithm.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
//https://leetcode-cn.com/problems/generate-parentheses/
public class Leetcode22 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }


    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }



/*
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (条件1) {
            cur.append('('); //做选择
            backtrack
            cur.deleteCharAt(cur.length() - 1); //撤回选择
        }
        if (条件2) {
            cur.append(')');//做选择
            backtrack
            cur.deleteCharAt(cur.length() - 1);//撤回选择
        }
    }
*/

}
