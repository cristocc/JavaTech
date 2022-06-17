package techArticle.algorithm.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by crist on 2021/4/27
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 * @author cc
 */
public class Test652 {

    Map<String,Integer> tree = new HashMap<>();
    List<TreeNode> answer = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return answer;
    }

    //返回序列化子树
    private String traverse(TreeNode root) {
        if(root == null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String treeSub = root.val + ","+ left +","+right;
        int count = tree.getOrDefault(treeSub,0);
        if(count == 1){
            answer.add(root);
        }
        tree.put(treeSub,count+1);
        return treeSub;
    }

}
