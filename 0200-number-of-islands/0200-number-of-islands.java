class Solution {
    private int rows;
    private int cols;
    public int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        rows = grid.length; 
        cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    bfs(grid, r, c);
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid, int r, int c) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{r, c});
        
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            for (int[] dir: dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if (0 <= nr && nr < rows && 0 <= nc && nc < cols && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    que.offer(new int[]{nr, nc});
                }
            }
        }





    }
}