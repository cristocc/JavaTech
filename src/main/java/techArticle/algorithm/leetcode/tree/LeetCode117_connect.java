package techArticle.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/4/27
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * @author cc
 */
public class LeetCode117_connect {

    List<List<Integer>> res ;
    int targetSum;
    List<Integer> temp ;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        this.targetSum = targetSum;
        dfs(root,0);
        return res;
    }

    public void dfs(TreeNode root, int sum){
        if(root == null){
            return;
        }
        int val = root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
           if(targetSum == sum + val){
               res.add(new ArrayList<>(temp));
           }
        }
        dfs(root.left,sum + val);
        dfs(root.right,sum + val);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        LeetCode117_connect test = new LeetCode117_connect();
        test.pathSum(node,3);
    }
}
