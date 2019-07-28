import java.util.ArrayList;

public class Solution {

    private ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        res = new ArrayList<>();
        if (root == null)
            return res;
        ArrayList<Integer> path = new ArrayList<>();
        rec(root, 0, target, path);
        return res;
    }

    private void rec(TreeNode node, int curSum, int target, ArrayList<Integer> path) {
        if (node == null)
            return;
        curSum += node.val;
        path.add(node.val);
        if (curSum == target && node.left == null && node.right == null)
            res.add(new ArrayList<>(path));
        rec(node.left, curSum, target, path);
        rec(node.right, curSum, target, path);

        path.remove(path.size() - 1);
    }
}