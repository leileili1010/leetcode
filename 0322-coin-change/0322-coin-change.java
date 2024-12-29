import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Initialize dp array
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2); // Use a large number as infinity
            dp[i][0] = 0; // 0 coins needed to make amount 0
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(
                        dp[i - 1][j],                    // Not using the i-th coin
                        dp[i][j - coins[i - 1]] + 1     // Using the i-th coin
                    );
                } else {
                    dp[i][j] = dp[i - 1][j]; // Cannot use the i-th coin
                }
            }
        }

        // The result is in dp[n][amount]
        return dp[n][amount] == Integer.MAX_VALUE / 2 ? -1 : dp[n][amount];
    }
}
