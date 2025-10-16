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
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        Node curr, prev = dummy;

        while (!stack.isEmpty()) {
            curr = stack.pop();
            curr.prev = prev;
            prev.next = curr;

            Node tempNext = curr.next;

            if (tempNext != null) stack.push(tempNext);
            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null;
            }
            prev = curr;
            
        }
        
        dummy.next.prev = null;
        return dummy.next;
    }

   
}