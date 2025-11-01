class Solution {
    int rows;
    int cols;
    int[][] steps = {{0,1}, {0,-1}, {-1, 0}, {1, 0}};
    
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = grid[i][j];
                if (c == '1' && !visited[i][j]) {
                    count++;
                    bfs(i, j, grid, visited);
                }
            }
        } 
        return count;
    }

    private void bfs(int row, int col, char[][] grid, boolean[][] visited) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{row, col});
        visited[row][col] = true;

        while (!que.isEmpty()) {
            int[] curr = que.poll();

            for (int[] step: steps) {
                int newRow = curr[0] + step[0];
                int newCol = curr[1] + step[1];
                if (isValid(newRow, newCol, grid, visited)) {
                    que.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    private boolean isValid(int row, int col, char[][] grid, boolean[][] visited) {
        return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == '1' && !visited[row][col];
    }
}