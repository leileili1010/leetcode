/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    private Node prev = null;

    public Node flatten(Node head) {
        if (head == null) return null;
        dfs(head);
        return head;
    }

    private void dfs(Node node) {
        if (node == null) return;

        Node next = node.next; // 保存原始 next

        // 连接前一个节点和当前节点
        if (prev != null) {
            prev.next = node;
            node.prev = prev;
        }

        prev = node; // 更新前驱节点

        // 递归 flatten child（相当于 preorder 的左子树）
        if (node.child != null) {
            dfs(node.child);
            node.child = null; // 清空 child
        }

        // 递归 flatten next（相当于 preorder 的右子树）
        dfs(next);
    }
}