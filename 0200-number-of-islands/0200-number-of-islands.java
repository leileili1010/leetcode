class Solution {
    int rows;
    int cols;
    int[][] steps = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {    
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count += 1;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int row = curr[0];
            int col = curr[1];
            
            for (int[] step: steps) {
                int newRow = row + step[0];
                int newCol = col + step[1];
                if (validCell(newRow, newCol) && !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                    que.offer(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                } 

            }
        }
    }

    private boolean validCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}