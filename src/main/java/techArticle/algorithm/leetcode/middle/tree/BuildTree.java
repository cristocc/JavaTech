package techArticle.algorithm.leetcode.middle.tree;

import techArticle.algorithm.leetcode.tree.TreeNode;

/**
 * Created by crist on 2022/7/21
 *
 * @author cc
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }


    public TreeNode dfs(int[] preorder,int preStart,int preEnd, int[] inorder,int inStart,int  inEnd) {
        if(preStart > preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        int index = 0;
        for(int i = inStart;i<=inEnd;i++){
            if(inorder[i] == rootVal){
                index = i;
                break ;
            }
        }
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left =dfs(preorder,preStart + 1,preStart + leftSize,inorder,inStart,index-1);
        root.right =dfs(preorder,preStart + leftSize + 1,preEnd,inorder,index + 1,inEnd);
        return root;
    }

    public static void main(String[] args) {
        int [] pre = {3,9,20,15,7};
        int [] in = {9,3,15,20,7};
        BuildTree bt = new BuildTree();
        bt.buildTree(pre,in);
    }

}
