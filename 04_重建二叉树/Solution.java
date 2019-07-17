/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return rec(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode rec(int[] pre, int pL, int pR, int[] in, int iL, int iR) {
        if (pL > pR || iL > iR)
            return null;
        TreeNode root = new TreeNode(pre[pL]);
        int lLen = 0;
        for (int i = iL; i <= iR && in[i] != pre[pL]; i++, lLen++)
            ;
        root.left = rec(pre, pL + 1, pL + lLen, in, iL, iL + lLen - 1);
        root.right = rec(pre, pL + lLen + 1, pR, in, iL + lLen + 1, iR);
        return root;
    }

    /**
     * supplement
     */
    public TreeNode reConstructBinaryTreeByInPost(int[] in, int[] post) {
        return recByInPost(in, 0, in.length - 1, post, 0, post.length - 1);
    }

    public TreeNode recByInPost(int[] in, int iL, int iR, int[] post, int poL, int poR) {
        if (iL > iR || poL > poR)
            return null;
        TreeNode root = new TreeNode(post[poR]);
        int lLen = 0;
        for (int i = iL; i <= iR && in[i] != post[poR]; i++, lLen++)
            ;
        root.left = rec(in, iL, iL + lLen - 1, post, poL, poL + lLen - 1);
        root.right = rec(in, iL + lLen + 1, iR, post, poL + lLen, poR);
        return root;
    }
}