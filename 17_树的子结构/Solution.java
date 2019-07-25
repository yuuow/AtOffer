public class Solution {
    // 判断 root2 是不是 root1 的子结构
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        boolean res = false;
        if (root1.val == root2.val)
            res = aContainsB(root1, root2);
        if (!res)
            res = HasSubtree(root1.left, root2); // root1 左边可能包含 root2
        if (!res)
            res = HasSubtree(root1.right, root2); // root1 右边可能包含 root2
        return res;
    }

    //判断 A 中是否包含 B(并不是相等)
    private boolean aContainsB(TreeNode A, TreeNode B) {
        if (B == null)
            return true; //B遍历完成，说明可以(A包含B)
        if (A == null)
            return false; //B没有遍历完，A已经遍历完成，不行
        return A.val == B.val && aContainsB(A.left, B.left) && aContainsB(A.right, B.right);
    }
}