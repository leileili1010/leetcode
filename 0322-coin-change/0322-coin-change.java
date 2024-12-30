class Solution {
    public int coinChange(int[] coins, int amount) {
        // state: minimum number of coins needed to make up the amount j using the first i coins.
        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];

        // initialzation
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i-1]) {
                    dp[i][j] = Math.min(
                        dp[i-1][j], 
                        dp[i][j - coins[i-1]] + 1);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount] == Integer.MAX_VALUE/2? -1: dp[n][amount]; 
    }
}