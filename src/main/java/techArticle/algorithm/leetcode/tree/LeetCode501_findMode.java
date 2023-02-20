package techArticle.algorithm.leetcode.tree;

import java.util.*;

/**
 * Created by crist on 2021/4/13
 *
 * @author cc
 */
public class LeetCode501_findMode {

    Map<Integer,Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for(Integer key:map.keySet()){
            if(map.get(key) == max){
                list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for(Integer val:list){
            ans[i] = val;
            i++;
        }
        return  ans;
    }

    public void dfs(TreeNode root){
        if(null == root){
            return;
        }
        Integer val = root.val;
        int temp = map.getOrDefault(val,0) + 1;
        max = Math.max(max,temp);
        map.put(val,temp);
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left =  new TreeNode(0);
        treeNode.right = new TreeNode(2);
        LeetCode501_findMode test = new LeetCode501_findMode();
        test.findMode(treeNode);
    }

}
