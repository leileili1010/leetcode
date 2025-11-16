class Solution {
    int[][] dp;
    int rows;
    int cols;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        // loop through each cell
        // check max and dfs result
        // dfs
            // if dp[i][j] != 0, return dp[i][j];
            // best = 1, loop through 4 directions, compare math.max(best, 1+ dfs(...));
            // return best
        rows = matrix.length;
        cols = matrix[0].length;
        dp = new int[rows][cols];
        this.matrix = matrix;
        int maxLen = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLen = Math.max(maxLen, dfs(i, j));
            }
        }
        return maxLen;
    }

    private int dfs(int row, int col) {
        // 1. base case
        if (dp[row][col] != 0) return dp[row][col];

        int best = 1;
        for (int[] dir: dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[row][col]) {
                best = Math.max(best, 1 + dfs(newRow, newCol));
            }
        }

        dp[row][col] = best;
        return best;
    }
}