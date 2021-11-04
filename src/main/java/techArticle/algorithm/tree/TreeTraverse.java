package techArticle.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by crist on 2021/5/18
 *
 * @author cc
 */
public class TreeTraverse {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    //前序遍历
    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        //先打印当前节点，然后打印左子树，最后再打印右子树
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    //中序遍历
    public void inOrderTraversal(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        //先打印左子树，然后打印当前节点，最后再打印右子树
        inOrderTraversal(root.left, res);
        res.add(root.val);
        inOrderTraversal(root.right, res);
    }

    public void afterOrderTraversal(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        //先打印左子树，然后打印当前节点，最后再打印右子树
        afterOrderTraversal(root.left, res);
        afterOrderTraversal(root.right, res);
        res.add(root.val);
    }

    static class TraverseStack{
        //他的访问顺序是：根节点→左子树→右子树
        //前序遍历 stack
        //DFS类似前驱遍历
        public static void preOrder(TreeNode tree) {
            if (tree == null)
                return;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(tree);//压栈
            while (!stack.empty()) {
                TreeNode t1 = stack.pop();//出栈
                System.out.println(t1.val);
                if (t1.right != null) {
                    stack.push(t1.right);
                }
                if (t1.left != null) {
                    stack.push(t1.left);
                }
            }
        }

        //他的访问顺序是：左子树→根节点→右子树
        public static void inOrderTraversal(TreeNode tree) {
            if (tree == null)
                return;
            Stack<TreeNode> stack = new Stack<>();
            while (tree != null || !stack.isEmpty()) {
                while (tree != null) {
                    stack.push(tree);
                    tree = tree.left;
                }
                if (!stack.isEmpty()) {
                    tree = stack.pop();
                    System.out.println(tree.val);
                    tree = tree.right;
                }
            }
        }

        //他的访问顺序是：左子树→右子树→根节点
        public static void postOrder(TreeNode tree) {
            if (tree == null)
                return;
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(tree);
            while (!s1.isEmpty()) {
                tree = s1.pop();
                s2.push(tree);
                if (tree.left != null) {
                    s1.push(tree.left);
                }
                if (tree.right != null) {
                    s1.push(tree.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + " ");
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        root.left = child1;
        root.right = child2;
        TraverseStack.postOrder(root);
    }

}
