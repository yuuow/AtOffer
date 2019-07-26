## [从上往下打印二叉树](https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">队列</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

#### 题目描述
> 从上往下打印出二叉树的每个节点，同层节点从左至右打印。

---

#### 思路
* 二叉树的层次遍历，借助队列实现
```java
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
```
