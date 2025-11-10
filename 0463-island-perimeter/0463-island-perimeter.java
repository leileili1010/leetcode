class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int rows, cols;

    public int islandPerimeter(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    // Start BFS once — there’s only one island
                    return bfs(i, j, visited, grid);
                }
            }
        }
        return 0;
    }

    private int bfs(int row, int col, boolean[][] visited, int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;
        int perimeter = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int[] d : dirs) {
                int x = r + d[0], y = c + d[1];
                // Out of bounds or water adds to perimeter
                if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0) {
                    perimeter++;
                } else if (!visited[x][y]) {
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }

        return perimeter;
    }
}
