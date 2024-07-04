class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        // Initialize the first element
        dp[0][0] = triangle.get(0).get(0);
        
        // Fill the dp array
        for (int i = 1; i < n; i++) {
            // Leftmost element of each row
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            // Fill the middle elements
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            }
            // Rightmost element of each row
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        
        // Find the minimum path sum in the last row
        int minTotal = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, dp[n - 1][i]);
        }
        
        return minTotal;
    }
}
