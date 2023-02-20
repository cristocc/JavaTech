package techArticle.algorithm.leetcode.tree;

import java.util.*;

/**
 * Created by crist on 2021/4/13
 *
 * @author cc
 */
public class LeetCode129_sumNumbers {

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        return  dfs(root,0);
    }

    public int dfs(TreeNode root,int prevSum){
        if(root == null){
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }

    }

    public static void main(String[] args) {
        LeetCode129_sumNumbers test = new LeetCode129_sumNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        test.sumNumbers(root);
    }






}
