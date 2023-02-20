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
public class LeetCode117_connect {

    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node pre = null;
            int size = queue.size();
            for(int i = 0;i<size;i++){
                Node node = queue.poll();
                if(pre != null){
                    pre.next = node;
                }
                pre = node;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


}
