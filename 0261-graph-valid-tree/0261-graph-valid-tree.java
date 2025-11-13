class Solution {
    public boolean validTree(int n, int[][] edges) {
        // check if edges == n-1
        // check if all nodes are connected, i.e. count == n
            // build graph
            // bfs and count node

        if (edges.length != n-1) return false;
        
        List<Integer>[] graph = new ArrayList[n];
        Deque<Integer> que = new ArrayDeque<>();        
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            int start = edge[0], end = edge[1];
            graph[start].add(end);
            graph[end].add(start);
        }

        int count = 0;
        que.offer(0);
        visited.add(0);

        while (!que.isEmpty()) {
            int cur = que.poll();
            count++;

            for (int next: graph[cur]) {
                if (!visited.contains(next)) {
                    que.offer(next);
                    visited.add(next);
                }
            }
        }

        return count == n;
        
    }
}