## [序列化二叉树](https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">队列</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

#### 题目描述

> 请实现两个函数，分别用来序列化和反序列化二叉树


----

<img width="60%" src="./images/61_s.png">

#### 思路
* 注意前序和层序的区别

前序序列化

```java
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serHelper(root, res);
        res.deleteCharAt(res.length() - 1); // notice, delete the last
        return res.toString();
    }

    public void serHelper(TreeNode root, StringBuilder sb) {
        if (root == null) { 
            sb.append("null,"); 
            return;
        }
        sb.append(root.val + ",");
        serHelper(root.left, sb);
        serHelper(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] arr = data.split(",");
        int[] idx = new int[1]; 
        return desHelper(arr, idx);
    }

    private TreeNode desHelper(String[] arr, int[] idx) {
        if (idx[0] >= arr.length)
            return null; 
        String val = arr[idx[0]];
        if (val.equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        idx[0]++;
        root.left = desHelper(arr, idx);
        idx[0]++;
        root.right = desHelper(arr, idx);
        return root;
    }
}
```

层序序列化

```java
import java.util.*;

public class Solution {
    String Serialize(TreeNode root) {
        StringBuilder sb = serHelper(root);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public StringBuilder serHelper(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null) {
            res.append("null,");
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode top = null;
        while (!queue.isEmpty()) {
            top = queue.poll();
            if (top != null) {
                res.append(top.val + ",");
                queue.add(top.left);
                queue.add(top.right);
            } else {
                res.append("null,");
            }
        }
        return res;
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) 
            return null;
        String[] arr = str.split(",");
        int idx = 0;
        TreeNode root = recon(arr[idx++]);
        if (root == null) 
            return root;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode top = null;
        while (!queue.isEmpty()) {
            top = queue.poll();
            top.left = recon(arr[idx++]);
            top.right = recon(arr[idx++]);
            if (null != top.left)
                queue.add(top.left);
            if (null != top.right)
                queue.add(top.right);
        }
        return root;
    }

    private TreeNode recon(String str) {
        return str.equals("null") ? null : new TreeNode(Integer.valueOf(str));
    }
}
```