class Solution {
    int rows;
    int cols;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
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

        while(!que.isEmpty()) {
            int[] cur = que.poll();

            for (int[] dir: dirs) {
                int newRow = cur[0] + dir[0], newCol = cur[1] + dir[1];
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