# BFS

```java
Deque<Node> que = new ArrayDeque<>();
HashMap<Node, Integer> distance = new HashMap<>();
que.offer(node);
distance.put(node, 0);

while (!que.isEmpty()) {
    Node node = que.poll();
    for (node neighbor: node.getNeighbors()) {
        if (distance.containsKey(neighbor)) {
            continue;
        }
        distance.put(neighbor, distance.get(node)+1);
        que.offer(neighbor);
    }
}
```