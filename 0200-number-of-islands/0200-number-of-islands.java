class Solution {
    int n;
    int m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0'|| visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(grid, visited, row, col+1);
        dfs(grid, visited, row, col-1);
        dfs(grid, visited, row+1, col);
        dfs(grid, visited, row-1, col);
    }
}