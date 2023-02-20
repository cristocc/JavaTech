package techArticle.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2021/4/27
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * @author cc
 */
public class LeetCode437_pathSum {

    public int pathSum(TreeNode root, int targetSum) {
        if(null == root){
            return 0;
        }

        int ret = dfs(root,targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;

    }

    public int dfs(TreeNode root, int targetSum){
        int ret = 0;
        if(null == root){
            return ret;
        }
        int val = root.val;
        if(val == targetSum){
            ret++;
        }
        ret += dfs(root.left, targetSum - val);
        ret += dfs(root.right, targetSum - val);

        return ret;

    }

}
