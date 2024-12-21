class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        // state & initialization
        dp[0][0] = 0; //没买stock
        dp[0][1] = -prices[0]; // 买了stock

        // function
        for (int i = 1; i < n; i++) {
            // max(继承昨天账户没股票今天不操作，昨天账户有股票，按几天股价今天卖了)
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // max(继承昨天账户有股票今天不操作，昨天账户没股票今天买了)
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }

        return dp[n-1][0];
    }
}