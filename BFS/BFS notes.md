# BFS

## 题型总结

![alt text](<屏幕截图 2025-01-04 104343.png>)

## Graph BFS
![alt text](<屏幕截图 2025-01-04 105447.png>)



## 数的BFS - Binary Tree level order traversal

- approach 1 - 单队列 (最推荐)

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
- approach 2 - dummy node

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> que = new LinkedList(); //只能用Queue + linkedlist来实现que, Deque + arrayDeque 不行，因为放入null会报错
        que.offer(root);
        que.offer(null);

        List<Integer> level = new ArrayList<>();
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node == null) {
                if (level.size() == 0) break; //当node == null && level也为空，结束
                
                res.add(level);
                level = new ArrayList<>();
                que.offer(null);
                continue;
            } 

            level.add(node.val);
            if (node.left != null) que.offer(node.left);
            if (node.right != null) que.offer(node.right);
        }
        System.out.print(res);
        return res;

    }
}
```

- approach 3 - 双队列

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            Deque<TreeNode> next_que = new ArrayDeque<>();
            List<Integer> level = new ArrayList<>();

            for (TreeNode node: que) {
                level.add(node.val);
                if (node.left != null) next_que.offer(node.left);
                if (node.right != null) next_que.offer(node.right);    
            }

            res.add(level);
            que = next_que;

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