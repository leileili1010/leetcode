class Solution {
    int rows;
    int cols;

    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int[][] dirs = {{1,0}, {-1, 0}, {0,1}, {0, -1}};
        int fresh = 0;
        int time = 0;
        
        Deque<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) que.offer(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;
        if (que.size() == 0) return -1;
        
        while (!que.isEmpty() && fresh > 0) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                int[] node = que.poll();
                int row = node[0];
                int col = node[1];
                for (int[] dir: dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (isValid(grid, newRow, newCol)) {
                        que.offer(new int[]{newRow, newCol});
                        grid[newRow][newCol] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0? time: -1;
    }

    private boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols
        && grid[row][col] == 1;
    }
}