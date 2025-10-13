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
    if (head == null) return head;
    // dummy node to ensure the `prev` pointer is never none
    Node dummy = new Node(-1, null, head, null);

    dfs(dummy, head);

    // detach the pseudo head from the real head
    dummy.next.prev = null;
    return  dummy.next;
  }
  /* return the tail of the flatten list */
  public Node dfs(Node prev, Node curr) {
    if (curr == null) return prev;
    curr.prev = prev;
    prev.next = curr;

    // the curr.next would be tempered in the recursive function
    Node tempNext = curr.next;

    Node tail = dfs(curr, curr.child);
    curr.child = null;

    return dfs(tail, tempNext);
  }
}