class Solution {
    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] distMatrix = new int[rows][cols];
        int canReachVal = 0; // 每一轮 BFS 只访问 grid == canReachVal 的格子
        int minTotalDist = Integer.MAX_VALUE;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) { // 从每个 building BFS

                    minTotalDist = Integer.MAX_VALUE; 
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{r, c, 0}); // row, col, distance

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int cr = cur[0], cc = cur[1], dist = cur[2];
                        int newDist = dist + 1;

                        for (int[] d : dirs) {
                            int nr = cr + d[0];
                            int nc = cc + d[1];

                            // 只访问“上一轮能达到”的空地
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                                && grid[nr][nc] == canReachVal) {

                                distMatrix[nr][nc] += newDist;
                                grid[nr][nc]--; // 把 0 → -1 → -2 → ...
                                queue.offer(new int[]{nr, nc, newDist});
                                minTotalDist = Math.min(minTotalDist, distMatrix[nr][nc]);
                            }
                        }
                    }

                    // 结束后，下一轮只能访问 grid == canReachVal - 1 的空地
                    canReachVal--;

                    // 若某一 building 找不到任何空地，说明全局无解
                    if (minTotalDist == Integer.MAX_VALUE) return -1;
                }
            }
        }

        return minTotalDist == Integer.MAX_VALUE ? -1 : minTotalDist;
    }
}