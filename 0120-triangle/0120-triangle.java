class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];

        // state
        for (int i = 0; i < n; i++) {
            dp[i] = new int[i+1];
        }

        dp[0][0] = triangle.get(0).get(0);

        //function...
        for (int i = 1; i < n; i++) {
            // leftmost
            dp[i][0] = triangle.get(i).get(0) + dp[i-1][0];
            
            for (int j = 1; j < i; j++) {
                // middle
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1], dp[i-1][j]);
            }
            
            // rightmost
            dp[i][i] = triangle.get(i).get(i) + dp[i-1][i-1];
        }

        // answer
        int min = dp[n-1][0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp[n-1][i]);
        }

        return min;
    }
}