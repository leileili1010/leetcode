class Solution {
    public int maxProfit(int[] prices) {
        int slow = 0, fast = 1, max = 0;

        while (fast < prices.length) {
            if (prices[fast] > prices[slow]) {
                int profit = prices[fast] - prices[slow];
                max = Math.max(max, profit);
            } else {
                slow = fast;
            }
            fast++;
        }

        return max;

    
    }
}