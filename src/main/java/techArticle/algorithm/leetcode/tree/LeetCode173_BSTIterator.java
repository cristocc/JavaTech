package techArticle.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode173_BSTIterator {

    Queue<Integer> list = new LinkedList<>();

    public LeetCode173_BSTIterator(TreeNode root) {
dfs(root);

    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        list.offer(root.val);
        dfs(root.right);
    }

    public int next() {
        return list.poll();
    }

    public boolean hasNext() {
        if(list.size() == 0){
            return false;
        }else {
            return true;
        }
    }

}
