class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            // 检查是否已经连通
            if (isConnected(graph, u, v, n)) {
                return edge; // 这条边造成环
            }
            // 加边
            graph[u].add(v);
            graph[v].add(u);
        }
        return new int[0];
    }

    private boolean isConnected(List<Integer>[] graph, int start, int target, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == target) return true;
            for (int nei : graph[node]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    queue.offer(nei);
                }
            }
        }
        return false;
    }
}
