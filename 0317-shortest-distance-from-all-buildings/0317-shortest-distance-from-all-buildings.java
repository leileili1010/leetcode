class Solution {

    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] distMatrix = new int[rows][cols];
        int canReachVal = 0;
        int minTotalDist = Integer.MAX_VALUE;

        // 遍历所有 building，逐个 BFS
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {

                    minTotalDist = bfsFromBuilding(r, c, grid, distMatrix, canReachVal);

                    // 若本次 BFS 没找到任何 reachable 空地，说明无解
                    if (minTotalDist == Integer.MAX_VALUE) return -1;

                    // 下一次 BFS，只能访问 grid == canReachVal - 1 的空地
                    canReachVal--;
                }
            }
        }

        return minTotalDist == Integer.MAX_VALUE ? -1 : minTotalDist;
    }

    /** 
     * 从某一栋 building 对 grid 做一次 BFS。
     * 返回：本 building 后更新的 distMatrix 里最小的 reachable 距离。
     */
    private int bfsFromBuilding(int sr, int sc, int[][] grid, int[][] distMatrix, int canReachVal) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc, 0}); // r, c, dist

        int localMin = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], dist = cur[2];
            int newDist = dist + 1;

            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                        && grid[nr][nc] == canReachVal) {

                    distMatrix[nr][nc] += newDist;
                    grid[nr][nc]--;  // 标记已被本 building 访问
                    queue.offer(new int[]{nr, nc, newDist});

                    localMin = Math.min(localMin, distMatrix[nr][nc]);
                }
            }
        }

        return localMin;
    }
}
