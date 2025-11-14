class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n  = edges.length;
        List<Integer>[] graph = new ArrayList[n+1];

        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e: edges) {
            int u = e[0], v= e[1];
            if (isConnected(u, v, graph, n)) return e;
            graph[u].add(v);
            graph[v].add(u);
        }

        return new int[0];
    }

    private boolean isConnected(int start, int target, List<Integer>[] graph, int n) {
        Deque<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        que.offer(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int node: graph[cur]) {
                if (node == target) return true;
                if (!visited[node]) {
                    que.offer(node);
                    visited[node] = true;
                }
            }
        }
        return false;
    }
}