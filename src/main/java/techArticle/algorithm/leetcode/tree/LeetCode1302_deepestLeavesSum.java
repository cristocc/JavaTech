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
public class LeetCode1302_deepestLeavesSum {

    Map<String,Integer> tree = new HashMap<>();
    List<TreeNode> answer = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return answer;
    }

    //返回序列化子树
    private String traverse(TreeNode root) {
        if(root == null) {
            return "#";
        }
        //得到序列化后的左子树
        String leftTree = traverse(root.left);
        //得到序列化后的右子树
        String rightTree = traverse(root.right);
        //后序遍历-自底向上地构建序列化子树-不断比较返回的子树是否已经存在
        String treeSub = root.val + "," + leftTree + "," + rightTree;
        int count = tree.getOrDefault(treeSub,0);
        //如果存在该子树
        if(count == 1) {
            //将该子树根节点存入结果集
            answer.add(root);
        }
        //子树数量递增
        tree.put(treeSub,count+1);
        return treeSub;
    }

}
