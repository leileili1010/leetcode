# BFS

## Basic Template
```java
// 1. 定义数据结构
Deque<Integer> que = new ArrayDeque<>();
HashSet<Integer> visited = new HashSet<>();

// 2. 初始入队列
que.offer(0);
visited.add(0);

// 3. 遍历
while (!que.isEmpty()) {
    // 弹出队首
    int cur = que.poll();

    // 找到当前点能一步到达的点
    for (int next_point: find_next(cur)) { // e.g 走四个方向
        // 不满足条件，跳过
        if (!isValid(next_point)) continue;

        // 若满足条件，入队同时更新visited, 这两个动作必须一起
        que.offer(next_point);
        visited.add(next_point);
    }
}
```

## 分层BFS

```java
// 1. 定义数据结构
Deque<Integer> que = new ArrayDeque<>();
HashSet<Integer> visited = new HashSet<>();

// 2. 初始入队列
que.offer(0);
visited.add(0);

// 3. 遍历
while (!que.isEmpty()) {
    int queSize = que.size();
    // 弹出队首
    int cur = que.poll();

    // 找到当前点能一步走到的点
    for (int i = 0; i < queSize; i++) {
        for (int next_point: find_next(cur)) {
            // 不满足条件，跳过
            if (!isValid(cur)) continue;
            // 满足条件，加入队列
            que.offer(next_point);
            visited.add(next_point);
        }
    }
}
```

## 字典优化版 - 找最短路径

```java
// 1. 定义数据结构
Deque<Integer> que = new ArrayDeque<>();
HashMap<Integer, Integer> distance = new HashMap<>();

// 2. 初始入队列
que.offer(0);
distance.put(0, 0);

// 3. 遍历
while (!que.isEmpty()) {
    // 弹出队首
    int cur = que.poll();

    // 找到当前能一步走到的所有点
    for (int next_point: find_next(cur)) {
        // 不满足条件 跳过
        if (!isValid(cur)) continue;
        // 满足 入队同时更新visited
        que.offer(next_point);
        distance.put(next_point, distance.get(cur) + 1);
    }
}
```

## 如何在二维数组上BFS

- Java; 把二维数组压缩成一维数组 (x, y) -> x * m + y, m is yxis length
    - visited 和 queue 都放数字
    - 如何复原x, y
        - x = cur / m
        - y = cur % m

## 拓扑排序
- 入度： 可以理解为该点有多少门先修课
- 一个图中可能存在多个拓扑序也可能不存在
- Graph + 依赖关系 + 有向 + 无环 => 拓扑排序 (一定无环)
- 题型
    - 求任意一个拓扑排序
    - 问是否存在拓扑排序
    - 求是否存在且存在一个拓扑排序
    - 求字典序最小的拓扑排序
- 算法描述：
    - 统计每个点的入度
    - 将入度为0的点放入队列作为起始节点
    - 不断从队列中拿出一个点，去掉这个点的所有连边
      - 指向其他点相应的入度 -1
    - 一旦发现新的入度为0的点，放入队列中
- 解题步骤
    - 建图
    - 建入度
    - 找出入度为0的点
    - BFS拓扑排序




