import java.util.Stack;

public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRoot;
        int cnt = 0;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            cnt++;
            if (k == cnt)
                return p;
            p = p.right;
        }
        return null;
    }

}