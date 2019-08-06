import java.util.*;

public class Solution {
    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }

    ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        res = new ArrayList<>();
        rec(pRoot, 0);
        return res;
    }

    private void rec(TreeNode node, int level) {
        if (node == null)
            return;
        if (res.size() <= level) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(node.val);
            res.add(tmp);
        } else {
            res.get(level).add(node.val);
        }
        rec(node.left, level + 1);
        rec(node.right, level + 1);
    }

}
