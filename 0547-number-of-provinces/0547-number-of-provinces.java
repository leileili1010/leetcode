class Solution {
    public int findCircleNum(int[][] isConnected) {
        // cities: 0, 1, 2...n-1
        // loop through each cell
            // if 1 count++, start bfs, using isConnected to find the next cell
            // visited to mark cities already connected

        int count = 0; 
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];

        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                count++;
                bfs(i, isConnected, visited);
            }
        }

        return count;
    }

    private void bfs(int city, int[][] isConnected, boolean[] visited) {
        Deque<Integer> que = new ArrayDeque<>();
        que.offer(city);
        visited[city] = true;

        while(!que.isEmpty()) {
            int cur = que.poll();

            for (int next = 0 ; next < isConnected[cur].length; next++) {
                if (isConnected[cur][next] == 1 && !visited[next]) {
                    que.offer(next);
                    visited[next] = true;
                } 
            }
        }
    }
}