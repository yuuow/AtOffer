## [树的子结构](https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

#### 题目描述

> 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

---

#### 思路
* 先判断 `root1.val==root2.val` ，然后再判断是否满足子结构关系（A中是否包含B）
* 如果上述条件不满足，然后再在 `root1.left` 和 `root1.right` 中循环递归判断
```java
public class Solution {
    // 判断 root2 是不是 root1 的子结构
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        boolean res = false;
        if (root1.val == root2.val)
            res = aContainsB(root1, root2);
        if (!res)
            res = HasSubtree(root1.left, root2); // root1 左边可能包含 root2
        if (!res)
            res = HasSubtree(root1.right, root2); // root1 右边可能包含 root2
        return res;
    }

    //判断 A 中是否包含 B(并不是相等)
    private boolean aContainsB(TreeNode A, TreeNode B) {
        if (B == null)
            return true; //B遍历完成，说明可以(A包含B)
        if (A == null)
            return false; //B没有遍历完，A已经遍历完成，不行
        return A.val == B.val && aContainsB(A.left, B.left) && aContainsB(A.right, B.right);
    }
}
```