/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // HashMap key is the original node and value is the copied node
        // loop through node to its neighbors
            // if map does not contain its neighbor, clone one
            // add cloned neighbor to the cloned node

        if (node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        Deque<Node> que = new ArrayDeque<>();
        
        que.offer(node);
        visited.put(node, new Node(node.val));

        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (Node neighbor: cur.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    que.offer(neighbor);
                    visited.put(neighbor, new Node(neighbor.val));
                }
                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}