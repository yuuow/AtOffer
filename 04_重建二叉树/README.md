## [重建二叉树](https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

## 题目描述

> 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

----
#### 思路(把握具体过程,递归求解)
* **前序遍历第一个节点就是根节点，然后在中序遍历中找到根节点所在位置，就可以得到左子树节点的个数 `iLen`**，则右子树结点的个数(总长度-左子树节点个数-1)
* 根节点左孩子的前序遍历 `pre[pL+1, pL+lLen]` 后序遍历 `in[iL, iL + lLen - 1]`
* 根节点右孩子的后序遍历 `pre[pL + lLen + 1 , pR]` 后序遍历 `in[iL + lLen + 1 , iR]`
* 重新构造，递归调用，求解

```java
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return rec(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode rec(int[] pre, int pL, int pR, int[] in, int iL, int iR) {
        if (pL > pR || iL > iR)
            return null;
        TreeNode root = new TreeNode(pre[pL]);
        int lLen = 0;
        for (int i = iL; i <= iR && in[i] != pre[pL]; i++, lLen++)
            ;
        root.left = rec(pre, pL + 1, pL + lLen, in, iL, iL + lLen - 1);
        root.right = rec(pre, pL + lLen + 1, pR, in, iL + lLen + 1, iR);
        return root;
    }
}
```

## 补充
> **只有前序遍历和中序遍历，中序遍历和后续遍历可确定一个二叉树**,前序遍历和后续遍历只能将子节点和父节点分离，并不能区分左右子树。

中序遍历和后续遍历,重建确定一颗二叉树

```java
public class Solution {
    public TreeNode reConstructBinaryTreeByInPost(int[] in, int[] post) {
        return rec(in, 0, in.length - 1, post, 0, post.length - 1);
    }

    public TreeNode rec(int[] in, int iL, int iR, int[] post, int poL, int poR) {
        if (iL > iR || poL > poR)
            return null;
        TreeNode root = new TreeNode(post[poR]);
        int lLen = 0;
        for (int i = iL; i <= iR && in[i] != post[poR]; i++, lLen++)
            ;
        root.left = rec(in, iL, iL + lLen - 1, post, poL, poL + lLen - 1);
        root.right = rec(in, iL + lLen + 1, iR, post, poL + lLen, poR);
        return root;
    }
}
```


