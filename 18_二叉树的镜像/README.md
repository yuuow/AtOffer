## [二叉树的镜像](https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

#### 题目描述

> 操作给定的二叉树，将其变换为源二叉树的镜像。

#### 输入描述
```
二叉树的镜像定义：

源二叉树 
                 8
                /  \
               6   10
              / \  / \
             5  7 9  11
镜像二叉树
                 8
                /  \
              10    6
             / \   / \
            11  9 7   5
```
---
<img width="80%" src="./images/18_s.png">  

#### 思路一(递归)
* 先交换当前根节点的左右子树；
* 然后递归依次交换自己的左右子树

```java
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        Mirror(root.left);
        Mirror(root.right);
    }
}
```
#### 思路二(非递归)
* 使用栈调用,非递归实现
```java
import java.util.Stack;

public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null || cur.right != null) {
                TreeNode t = cur.left;
                cur.left = cur.right;
                cur.right = t;
            }
            if (cur.left != null)
                stack.push(cur.left);
            if (cur.right != null)
                stack.push(cur.right);
        }
    }
}
```