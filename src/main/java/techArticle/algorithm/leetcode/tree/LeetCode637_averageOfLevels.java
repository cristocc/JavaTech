package techArticle.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode637_averageOfLevels {

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double val = 0;
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                val += node.val;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            val /= size;
            ans.add(val);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        averageOfLevels(node);
    }

}
