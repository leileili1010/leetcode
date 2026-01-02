class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];

        // state: dp[i][j] means shortest path from top to the current triangle[i][j]
        for (int i = 0; i < n; i++) {
            dp[i] = new int[i+1];
        }

        // init: dp[0][0] = triangle.get(0).get(0);
        dp[0][0] = triangle.get(0).get(0);

        // function
        // leftMost: dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
        // rightMost: dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
        // mid: dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1], dp[i-1][j]);
        for (int i = 1; i < n; i++) {
            // leftMost
            dp[i][0] = triangle.get(i).get(0) + dp[i-1][0];
            
            // mid
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1], dp[i-1][j]);
            }

            // rightMost 
            dp[i][i] = triangle.get(i).get(i) + dp[i-1][i-1];
        }
        return Arrays.stream(dp[n-1]).min().getAsInt();
    }
}