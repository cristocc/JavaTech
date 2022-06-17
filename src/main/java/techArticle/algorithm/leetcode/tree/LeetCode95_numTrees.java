package techArticle.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2021/4/27
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * @author cc
 */
public class LeetCode95_numTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new LinkedList<>();
        }
        // 构造闭区间 [1, n] 组成的 BST
        return build(1, n);
    }

    /* 构造闭区间 [lo, hi] 组成的 BST */
    List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (lo > hi) {
            res.add(null);
            return res;
        }
        // 1、穷举 root 节点的所有可能。
        for (int i = lo; i <= hi; i++) {
            // 2、递归构造出左右子树的所有合法 BST。
            List<TreeNode> leftTree = build(lo, i - 1);
            List<TreeNode> rightTree = build(i + 1, hi);
            // 3、给 root 节点穷举所有左右子树的组合。
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i 作为根节点 root 的值
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode95_numTrees tt = new LeetCode95_numTrees();
        tt.generateTrees(3);
    }

}
