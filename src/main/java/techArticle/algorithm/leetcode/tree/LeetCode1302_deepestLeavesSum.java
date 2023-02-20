package techArticle.algorithm.leetcode.tree;

import java.util.*;

/**
 * Created by crist on 2021/4/27
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 * @author cc
 */
public class LeetCode1302_deepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        if(null == root){
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            sum = 0;
            int size = queue.size();
            for (int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return sum;

    }

    public int[] swapNumbers(int[] numbers) {

        numbers[0]^=numbers[1];
        numbers[1]^=numbers[0];
        numbers[0]^=numbers[1];
        return numbers;

    }

}
