public class Solution {
    //方法一
    boolean isSymmetrical1(TreeNode pRoot) {
        return pRoot == null ? true : mirror(pRoot.left, pRoot.right);
    }

    private boolean mirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return left.val == right.val && mirror(left.left, right.right) && mirror(left.right, right.left);
    }

}