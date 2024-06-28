class Solution {
    int rows;
    int cols;
    int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        
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

    public void bfs(char[][] grid, int i, int j) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {i, j});
        grid[i][j] = 0;

        while (!que.isEmpty()) {
            int[] node = que.poll();
            int row = node[0];
            int col = node[1];

            for (int[] step: steps) {
                int newRow = row + step[0];
                int newCol = col + step[1];
                if ( 0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols && grid[newRow][newCol] == '1') {
                   que.offer(new int[]{newRow, newCol});
                   grid[newRow][newCol] = '0';
                }
            }
        }


    }
}