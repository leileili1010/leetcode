
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // valid tree:
        // 1. All nodes are connected
        // 2. no cycle

        // check for cycle
        if (edges.length != n-1) return false;
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        } 

        for (int[] edge: edges) {
            int start = edge[0], end = edge[1];
            graph[start].add(end);
            graph[end].add(start);
        }

        Deque<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        que.offer(0);
        visited[0] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int neighbor: graph[cur]) {
                if (!visited[neighbor]) {
                    que.offer(neighbor);
                    visited[neighbor] = true;
                };
            }
        }

        return visited.length == n? true: false;
    }
}