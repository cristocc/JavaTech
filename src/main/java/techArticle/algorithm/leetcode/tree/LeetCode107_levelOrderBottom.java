package techArticle.algorithm.leetcode.tree;

import java.util.*;

/**
 * Created by crist on 2021/4/13
 *
 * @author cc
 */
public class LeetCode107_levelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                level.add(node.val);

                TreeNode left = node.left;
                TreeNode right = node.right;
                if(left!= null){
                    queue.offer(left);
                }
                if(right!= null){
                    queue.offer(right);
                }
            }
            res.add(level);
        }
         Collections.reverse(res);;
         return res;
    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(root,0,res);
        return res;
    }

    public  void dfs(TreeNode root,int deepth,List<List<Integer>> res){
        if(root == null){
            return;
        }
        if(deepth == res.size()){
            res.add(0,new ArrayList<>());
        }
        res.get(res.size() - deepth - 1).add(root.val);

        dfs(root.left,deepth + 1,res);
        dfs(root.right,deepth + 1,res);
    }






}
