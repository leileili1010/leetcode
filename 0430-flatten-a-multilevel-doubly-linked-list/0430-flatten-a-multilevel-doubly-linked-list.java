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
    public Node flatten(Node head) {
        if (head == null) return null;

        Node dummy = new Node(-1, null, head, null);
        dfs(dummy, head);

        dummy.next.prev = null;
        return dummy.next;
    }

    private Node dfs(Node prev, Node cur) {
        if (cur == null) return prev;

        // connect prev and cur
        prev.next = cur;
        cur.prev = prev;
        Node tempNext = cur.next;

        // find the tail if cur has a child
        Node tail = dfs(cur, cur.child);

        // remove child of prev
        cur.child = null;

        // connect tail with prev.next
        return dfs(tail, tempNext);
    } 
}