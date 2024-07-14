class Solution {
    public int uniquePaths(int m, int n) {
        // state, dp[i][j] means No.of paths
        int[][] dp = new int[m][n];

        // initialize row 0 and col 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // function
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        // answer
        return dp[m-1][n-1];
    }
}