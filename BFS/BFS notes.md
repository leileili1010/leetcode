# BFS

## 题型总结


### Binary tree level order traversal 

```java
 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> que = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        que.offer(root);
        
        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> list = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                 TreeNode node = que.poll();
                 list.add(node.val);

                 if (node.left != null) {
                    que.offer(node.left);
                 }
                 if (node.right != null) {
                    que.offer(node.right);
                 }
            }
            res.add(list);
        }
        return res;
    }
}
```






```java
// 单队列
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