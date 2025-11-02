/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // corner case
        if (root == null) return null;
        
        Deque<Node> que = new ArrayDeque<>();
        que.offer(root);

       
        while (!que.isEmpty()) {
            int n = que.size();
            Node prev = null;
            
            for (int i = 0; i < n; i++) {
                Node cur = que.poll();
                if (prev != null) prev.next = cur;
                prev = cur;

                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
        }

        return root;
    }
}