class Solution {
    public int orangesRotting(int[][] grid) {
        // loop every cell to find all rotten oranges
        // put them in queue and do a level order traversal
        int time = 0, fresh = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> que = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) que.offer(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        while (!que.isEmpty() && fresh > 0) {
            int n = que.size();
            time++;

            for (int i = 0; i < n; i++) {
                int[] cur = que.poll();

                for (int[] dir: dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];

                    if (isValid(x, y, grid)) {
                        grid[x][y] = 2;
                        que.offer(new int[]{x, y});
                        fresh--;
                        if (fresh == 0) return time;
                    }
                }
            }
        }

        return fresh == 0? time: -1;
    }

    private boolean isValid(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1;
    }
}