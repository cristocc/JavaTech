package techArticle.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode653_findTarget {

    List<Integer> track = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int start = 0;
        int end = track.size() -1;
        while (start < end){
            int val = track.get(start) + track.get(end);
            if( val == k){
                return true;
            }else if(val > k){
                end--;
            }else{
                start++;
            }
        }
        return false;
    }

    public void dfs(TreeNode root){
        if(null == root){
            return;
        }

        dfs(root.left);
        track.add(root.val);
        dfs(root.right);

    }

    public static void main(String[] args) {
        LeetCode653_findTarget test = new LeetCode653_findTarget();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        test.findTarget(root,1);

    }

}
