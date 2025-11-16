class Solution {
    int rows;
    int cols;
    int[][] steps = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, bfs(i, j, grid, visited));
                }
            }
        }
        return max;
    }

    private int bfs(int row, int col, int[][] grid, boolean[][] visited) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{row, col});
        visited[row][col] = true;
        int area = 0;

        while(!que.isEmpty()) {
            int[] cur = que.poll();
            area++;

            for (int[] step: steps) {
                int newRow = cur[0] + step[0];
                int newCol = cur[1] + step[1];

                if (isValid(newRow, newCol, grid, visited)) {
                    que.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }    
        return area;    
    }

    private boolean isValid(int x, int y, int[][] grid, boolean[][] visited) {
       return x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1 && !visited[x][y];
    }
}