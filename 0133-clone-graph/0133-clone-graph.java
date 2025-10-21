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

        que.offer(node); // que: 1
        visited.put(node, new Node(node.val, new ArrayList<>())); // visited: 1

        while(!que.isEmpty()) { // que: 2, 4
            Node curr = que.poll(); // curr = 2

            for (Node neighbor: curr.neighbors) { // 3: 1,3
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>())); // visited: 1,2, 4, 3
                    que.offer(neighbor); // que: 4, 3
                }
                visited.get(curr).neighbors.add(visited.get(neighbor)); // new node 2.neighbors = 1, 3
            }
        }
        return visited.get(node);
    }
}