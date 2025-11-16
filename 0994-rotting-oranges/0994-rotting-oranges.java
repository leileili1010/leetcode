class Solution {
    private int rows, cols;
    private int[][] dirs = {{1,0}, {-1, 0}, {0,1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int fresh = 0;
        Deque<int[]> que = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) {
                    que.offer(new int[]{i, j});
                }
            }
        }

        int count = 0;
        while (!que.isEmpty() && fresh > 0) {
            int n = que.size();
            count++;

            for (int i = 0; i < n; i++) {
                int[] cur = que.poll();
                
                for (int[] dir: dirs) {
                    int row = cur[0] + dir[0], col = cur[1] + dir[1];
                    if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        que.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0? count: -1;
    }
}