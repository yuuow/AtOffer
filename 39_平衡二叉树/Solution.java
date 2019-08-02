public class Solution {
    //方法一 递归
    public boolean IsBalanced_Solution1(TreeNode root) {
        if (root == null)
            return true;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right)
                && (Math.abs(depth(root.left) - depth(root.right))) <= 1;
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    //方法二
    public boolean IsBalanced_Solution2(TreeNode root) {
        if (root == null)
            return true;
        return height(root) > -1;
    }

    private int height(TreeNode node) {
        if (root == null)
            return 0;
        int LH = height(node.left);
        int LR = height(node.right);
        if (Math.max(LH, LR) > 1 || LH == -1 || LR == -1)
            return -1;
        return Math.max(LH, LR) + 1;
    }

}