class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];

        // state: dp[i][j] from triangle[i][j] to bottom shortest path
        for (int i = 0; i < n; i++) {
            dp[i] = new int[i+1];
        }

        // init: dp[n-1] row
        for (int j = 0; j < n; j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        // function
        // dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1])
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }
}