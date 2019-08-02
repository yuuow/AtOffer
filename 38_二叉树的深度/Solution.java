import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int TreeDepth1(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    public int TreeDepth2(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0, nextLevelSize = 1, depth = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            count++;
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
            if (count == nextLevelSize) {
                count = 0;
                depth++;
                nextLevelSize = queue.size();
            }
        }
        return depth;
    }
}