class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] distSum = new int[m][n];
        int[][] reach = new int[m][n];

        int totalBuildings = 0;

        // 统计 building 数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                }
            }
        }

        // 对每个 building 做 BFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(i, j, grid, distSum, reach);
                }
            }
        }

        int result = Integer.MAX_VALUE;

        // 找空地中 reach = totalBuildings 的点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == totalBuildings) {
                    result = Math.min(result, distSum[i][j]);
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void bfs(int sr, int sc, int[][] grid, int[][] distSum, int[][] reach) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        int dist = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;

            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1];

                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                        && !visited[nr][nc] && grid[nr][nc] == 0) {

                        visited[nr][nc] = true;
                        distSum[nr][nc] += dist;
                        reach[nr][nc]++;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
