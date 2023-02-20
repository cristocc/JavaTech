package techArticle.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by crist on 2021/4/27
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * @author cc
 */
public class LeetCode199_rightSideView {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    public void dfs(TreeNode root ,int depth){
        if(root == null){
            return;
        }
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        depth++;
        dfs(root.right,depth);
        dfs(root.left, depth);
    }

    public List<Integer> rightSideView1(TreeNode root) {
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(i == size - 1){
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }


}
