package techArticle.algorithm.leetcode.interview;

import techArticle.algorithm.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by crist on 2022/8/9
 * https://leetcode.cn/problems/kTOapQ/
 * @author cc
 */
public class LeetCode_BSTIterator {

    Queue<Integer> list = new LinkedList<>();

    public LeetCode_BSTIterator(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root){
        if(null == root){
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
        return !list.isEmpty();
    }
}
