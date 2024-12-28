

import static java.lang.Math.max;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // state: dp[i][j] means sum of paths to i,j
        dp[0][0] = obstacleGrid[0][0] == 1? 0: 1;

        // initialization: first row and first col
        for (int j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1? 0: dp[0][j-1];
            // System.out.print(dp[0][j]);
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1? 0: dp[i-1][0];
            // System.out.print(dp[i][0]);
        }

        // function
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1? 0: dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];


    }
}