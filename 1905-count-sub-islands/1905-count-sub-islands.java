class Solution {
    int rows, cols;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        rows = grid1.length;
        cols = grid1[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // 只从 grid2 的岛屿开始 DFS
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    // DFS 返回 true = 这是一个 sub island
                    if (dfs(grid1, grid2, visited, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2,
                        boolean[][] visited, int r, int c) {
        // 越界/水/访问过 → 不影响 sub island 的有效性
        if (r < 0 || r >= rows || c < 0 || c >= cols)
            return true;
        if (grid2[r][c] == 0 || visited[r][c])
            return true;

        visited[r][c] = true;

        // 判断当前点是否合法（grid1 必须也是 1）
        boolean valid = (grid1[r][c] == 1);

        // DFS 四个方向，同时必须全部都 valid
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            boolean child = dfs(grid1, grid2, visited, nr, nc);
            valid = valid && child;
        }

        return valid;
    }
}
