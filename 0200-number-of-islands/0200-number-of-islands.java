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
                if (grid[i][j] == '1' && !visited[i][j]) {
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
            int[] cur = que.poll();

            for (int[] dir: dirs) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];

                if (isValid(x, y, visited, grid)) {
                    que.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }

    private boolean isValid(int x, int y, boolean[][] visited, char[][] grid) {
        return x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1' && !visited[x][y];
    }
}