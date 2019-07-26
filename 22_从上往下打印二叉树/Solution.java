import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            res.add(cur.val);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        return res;
    }
}