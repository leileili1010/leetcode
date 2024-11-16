class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];

        // state: dp[i][j] means minPath from bottom to cur
        for (int i = 0; i < n; i++) {
            dp[i] = new int[n+1];
        }

        // initialization
       for (int j = 0; j < n; j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
       }

       // function
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }

       return dp[0][0];
    }
}