class Solution {
    int m;
    int n;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        // count island: 
            // loop elements, increase count by 1 if we found '1'
        // bfs for '1' element
            // boolean[][] visited in main function
            // deque and go 4 dirs 
        
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
       if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] != '1') {
            return;
       }

       visited[row][col] = true;
       dfs(grid, visited, row, col+1);
       dfs(grid, visited, row, col-1);
       dfs(grid, visited, row+1, col);
       dfs(grid, visited, row-1, col);
    }
}