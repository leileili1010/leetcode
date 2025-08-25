class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i= 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e: edges) {
            int start = e[0], end = e[1];
            graph[start].add(end);
            graph[end].add(start);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                bfs(i, visited, graph);
            }
        }

        return count;
    }

    private void bfs(int node, boolean[] visited, List<Integer>[] graph) {
        Deque<Integer> que = new ArrayDeque<>();
        que.offer(node);
        visited[node] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int neighbor: graph[cur]) {
                if (!visited[neighbor]) {
                    que.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}