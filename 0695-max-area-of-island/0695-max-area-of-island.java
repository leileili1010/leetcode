class Solution {
    int rows;
    int cols;
    int[][] steps = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = bfs(i, j, grid, visited);
                    max = Math.max(max, area);
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

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            area++;

            for (int[] step: steps) {
                int x = cur[0] + step[0];
                int y = cur[1] + step[1];
                if (isValid(x, y, grid, visited)) {
                    que.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return area;
    }

    private boolean isValid(int x, int y, int[][] grid, boolean[][] visited) {
        return x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1 && !visited[x][y];
    }
}