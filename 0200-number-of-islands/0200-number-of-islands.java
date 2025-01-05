class Solution {
    int rows;
    int cols;
    int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int count = 0;
        rows = grid.length; 
        cols = grid[0].length; 

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {i, j});
        grid[i][j] = 0;

        while (!que.isEmpty()) {
            int[] island = que.poll();
            int row = island[0];
            int col = island[1];

            for (int[] step: steps) {
                int newRow = row + step[0];
                int newCol = col + step[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                    que.offer(new int[] {newRow, newCol});
                    grid[newRow][newCol] = 0;
                }
            }
        }


    }
}