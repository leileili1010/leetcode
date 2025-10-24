

import static java.lang.Integer.parseInt;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        Node curr = p;

        while (curr != null) {
            set.add(curr);
            curr = curr.parent;

        }

        curr = q;
        while (curr != null) {
            if (set.contains(curr)) return curr;
            curr = curr.parent;
        }
        
        return null;

    }   
}