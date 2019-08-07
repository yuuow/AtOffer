public class Solution {
    //前序
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serHelper(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void serHelper(Treenode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        serHelper(root.left, sb);
        serHelper(root.right, sb);
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0)
            return null;
        String[] data = str.split(",");
        int[] idx = new int[1];
        return desHelper(data, idx);
    }

    private TreeNode desHelper(String[] arr, int[] idx) {
        if (idx[0] >= arr.length)
            return null;
        String val = arr[idx[0]];
        if ("null".equals(val))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        idx[0]++;
        root.left = desHelper(arr, idx);
        idx[0]++;
        root.right = desHelper(arr, idx);
        return root;
    }

}