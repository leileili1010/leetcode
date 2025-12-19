/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1. copy and insert
        for (Node cur = head; cur != null; cur = cur.next.next) {
            cur.next = new Node(cur.val, cur.next);
        }

        // 2. random
        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) cur.next.random = cur.random.next;
        }

        // 3. split
        Node newHead = head.next;
        Node cur = head;
        for (; cur.next.next != null; cur = cur.next) {
            Node copy = cur.next;
            cur.next = copy.next;
            copy.next = copy.next.next;
        }

        cur.next = null;
        return newHead;
    }
}