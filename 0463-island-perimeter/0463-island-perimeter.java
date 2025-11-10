class Solution {
    int rows;
    int cols;
    int[][] steps = {{0,1}, {0, -1}, {-1, 0}, {1, 0}};
    int perimeter;

    public int islandPerimeter(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        perimeter = 0;
        boolean[][] visited = new boolean[rows][cols]; 
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, visited, grid);
                }
            }
        }

        return perimeter + 1;     
    }

    private void bfs(int row, int col, boolean[][] visited, int[][] grid) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{row, col});
        visited[row][col] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            perimeter += 3;
            
            for (int[] step: steps) {
                int x = cur[0] + step[0];
                int y = cur[1] + step[1];

                if (isValid(x, y, visited, grid)) {
                    que.offer(new int[] {x, y});
                    visited[x][y] = true;
                    perimeter--;
                }
            }
        }
    }

    private boolean isValid(int x, int y, boolean[][] visited, int[][] grid) {
        return x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && grid[x][y] == 1;
    }
}