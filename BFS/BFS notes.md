# BFS

## 题型总结

![alt text](<屏幕截图 2025-01-04 104343.png>)

## Graph BFS
![alt text](<屏幕截图 2025-01-04 105447.png>)

![alt text](<屏幕截图 2025-01-04 110929.png>)

```java
// 单队列
Deque<Node> que = new ArrayDeque<>();
HashMap<Node, Integer> distance = new HashMap<>(); // 无向图用于去重 （有向图有可能需要放入重复节点）

// step1: 初始化
// 初始节点放到que里，如果有多个就都放进去
// 并标记初始节点的剧为0，记录在distance的Hashmap里
// distance 有两个作用，一是判断是否已经访问过，二是记录离起点的位置
que.offer(node);
distance.put(node, 0); //一旦入队列马上标记

// step2: 不断访问队列 + pop 队列中的一个node
while (!que.isEmpty()) {
    Node node = que.poll();
    // step 3: 拓展相邻节点
    // pop出的节点的相邻节点，加入队列并在distance中存储距离
    for (node neighbor: node.getNeighbors()) { //遍历邻居
        if (distance.containsKey(neighbor)) {
            continue;
        }
        que.offer(neighbor);
        distance.put(neighbor, distance.get(node)+1); //一旦入队列马上标记
    }
}
```
- time: N个点，M条边，O(N+M) or O(M); M最坏为O(N^2) 如果任意两个点都有边


## 数的BFS - Binary Tree level order traversal

- approach 1 - 单队列 (最推荐)

```java
// 分层
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



