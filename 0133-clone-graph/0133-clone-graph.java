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
        HashMap<Node, Node> map = new HashMap<>();

        que.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while (!que.isEmpty()) {
            Node curr = que.poll();

            for (Node neighbor: curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    que.offer(neighbor);
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}