class Solution {
    private int[][] matrix;
    private int rows, cols;
    private int[][] dp;   // memoization
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        dp = new int[rows][cols];

        int maxLen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLen = Math.max(maxLen, dfs(i, j));
            }
        }
        return maxLen;
    }

    private int dfs(int r, int c) {
        if (dp[r][c] != 0) return dp[r][c];  // already computed

        int best = 1;  // at least the cell itself

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols 
                && matrix[nr][nc] > matrix[r][c]) {
                best = Math.max(best, 1 + dfs(nr, nc));
            }
        }

        dp[r][c] = best;
        return best;
    }
}
