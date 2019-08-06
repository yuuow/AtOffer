public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
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