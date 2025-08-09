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
        if (node == null) return null;

        Deque<Node> que = new ArrayDeque<>();
        HashMap<Node, Node> visited = new HashMap<>();
        que.offer(node);
        visited.put(node, new Node(node.val));

        while (!que.isEmpty()) {
            Node curr = que.poll();
            for (Node neighbor: curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    que.offer(neighbor);
                    visited.put(neighbor, new Node(neighbor.val));
                }
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}