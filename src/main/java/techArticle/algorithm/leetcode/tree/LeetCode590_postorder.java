package techArticle.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/4/13
 *
 * @author cc
 */
public class LeetCode590_postorder {

    class Node {
        public int val;
        public List<Node> children;
        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if(null == root){
            return ans;
        }

        helper( root);
        return ans;
    }

    public void helper(Node root) {
        if (root == null) {
            return;
        }
        List<Node> node = root.children;
        for(int i=0;i<node.size();i++){
            helper(node.get(i));
        }
        ans.add(root.val);
    }


}
