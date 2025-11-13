class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e: edges) {
            int start = e[0], end = e[1];
            graph[start].add(end);
            graph[end].add(start);
        }


        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                bfs(i, visited, graph);
            }
        }

        return count;
    }

    private void bfs(int num, Set<Integer> visited, List<Integer>[] graph) {
        Deque<Integer> que = new ArrayDeque<>();
        que.offer(num);
        visited.add(num);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next: graph[cur]) {
                if (!visited.contains(next)) {
                    que.offer(next);
                    visited.add(next);
                }
            }
        } 
    }
}