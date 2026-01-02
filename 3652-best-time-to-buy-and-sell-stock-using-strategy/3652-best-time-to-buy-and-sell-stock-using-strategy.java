class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] sum = new long[n+1];
        long[] sumPrice = new long[n+1];

        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + prices[i] * strategy[i];
            sumPrice[i+1] = sumPrice[i] + prices[i];
        }

        long res = sum[n];
        for (int i = k; i <= n; i++) {
            long windowSum = sum[i-k] + sum[n] - sum[i] + sumPrice[i] - sumPrice[i-k/2];
            res = Math.max(res, windowSum);
        }
        return res;
        
    }
}