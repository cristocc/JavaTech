package techArticle.algorithm.leetcode.tree;

import java.util.*;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode103_zigzagLevelOrder {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == root){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            if(depth % 2 != 0){
                Collections.reverse(temp);
            }
            result.add(temp);
            depth++;
        }
        return result;
    }
}
