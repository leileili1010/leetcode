class Solution {
    int rows;
    int cols;
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // loop through grid2 
        // if we found 1 && not visited before, start bfs
        // bfs
            // using grid1 to check if it is a subisland
            // mark all connected as visited
            // return bolean is subisland
        // if is subisland, count++
        
        rows = grid2.length;
        cols = grid2[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid2[i][j] == 1) {
                    boolean isSubisland = bfs(i, j, grid2, grid1, visited);
                    if (isSubisland) count++;
                }
            }
        }
        return count;
    }

    private boolean bfs(int row, int col, int[][] grid2, int[][] grid1, boolean[][] visited) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{row, col});
        visited[row][col] = true;
        boolean isSubisland = true;

        while(!que.isEmpty()) {
            int[] cur = que.poll();
            if (grid1[cur[0]][cur[1]] != 1 && isSubisland) isSubisland = false;
           
            for (int[] dir: dirs) {
                int newRow = dir[0] + cur[0];
                int newCol = dir[1] + cur[1];

                if (isValid(newRow, newCol, grid2, visited)) {
                    que.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return isSubisland;
    }

    private boolean isValid(int row, int col, int[][] grid, boolean[][] visited) {
        return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1 
                && !visited[row][col];
    }
     
}