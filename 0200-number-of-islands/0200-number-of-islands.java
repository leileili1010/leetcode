class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    bfs(i, j, grid, visited, steps);
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, char[][] grid, boolean[][] visited, int[][] steps) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{row, col});
        visited[row][col] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int[] step: steps) {
                int newRow = cur[0] + step[0];
                int newCol = cur[1] + step[1];

                if (isValid(newRow, newCol, grid, visited)) {
                    que.offer(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                }
 
            }

        }
    }

    private boolean isValid(int row, int col, char[][] grid, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        return row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col] && grid[row][col] == '1';
    }
}
