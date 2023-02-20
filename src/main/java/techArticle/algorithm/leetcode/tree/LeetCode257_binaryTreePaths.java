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
public class LeetCode257_binaryTreePaths {


    List<String> ans = new ArrayList<>();
    LinkedList<String> temp = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null){
            return paths;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        queue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                String path = pathQueue.poll();
                if(node.left == null && node.right == null){
                    paths.add(path);
                }else{
                    if(node.left != null){
                        queue.offer(node.left);
                        pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                        pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                    }
                }
            }
        }
        return ans;
    }

    List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths1(TreeNode root) {
        dfs(root,"");
        return paths;
    }

    public void dfs(TreeNode root, String path) {
        if(root == null){
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val + "");
        if(root.left == null && root.right == null){
            paths.add(sb.toString());
        }else{
            sb.append("->");
            dfs(root.left,sb.toString());
            dfs(root.right,sb.toString());
        }
    }

    public void dfs(TreeNode root){

    }

    public static void main(String[] args) {
        LeetCode257_binaryTreePaths test = new LeetCode257_binaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        test.binaryTreePaths(root);

    }

}
