## [二叉树的下一个结点](https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

#### 题目描述

> 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。


---

#### 思路
1. 二叉树为空，则返回空；
2. 节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
3. 节点右孩子不存在；如果该节点是其父节点的左孩子，则返回父节点；如果该节点是其父节点的右孩子，继续向上遍历其父节点的父节点，重复判断，返回结果。

```java
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // next 是父节点的意思
        if (pNode == null)
            return null;
        // 右孩子的最左节点
        if (pNode.right != null)
            return getMostLeft(pNode.right);
        // 父亲节点
        if (pNode.next != null && pNode.next.left != null && pNode.next.left == pNode)
            return pNode.next;
        // 不断的往上找
        while (pNode.next != null && pNode.next.right != null && pNode.next.right == pNode)
            pNode = pNode.next;
        return pNode.next;
    }

    //获取 node 最左节点
    public TreeLinkNode getMostLeft(TreeLinkNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
}
```
