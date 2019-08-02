## [平衡二叉树](https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

#### 题目描述

> 输入一棵二叉树，判断该二叉树是否是平衡二叉树。

---
* 平衡二叉树
    > 一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。

#### 思路一(递归)

```java
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right)
                && (Math.abs(depth(root.left) - depth(root.right))) <= 1;
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
```

#### 思路二(非递归)
* 简写方式，直接根据函数返回值判断
```java
public class Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        return height(root) > -1;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        int LH = height(node.left);
        int RH = height(node.right);
        if (Math.abs(LH - RH) > 1 || LH == -1 || RH == -1)
            return -1;
        return Math.max(LH, RH) + 1;
    }
}
```
