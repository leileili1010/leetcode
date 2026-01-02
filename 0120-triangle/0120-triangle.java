class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // state: dp[i] from triangle[i][j] to bottom shortest path
        // init: dp[n-1] row
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n-1).get(j);
        }

        // function
        // dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1])
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }

        return dp[0];
    }
}