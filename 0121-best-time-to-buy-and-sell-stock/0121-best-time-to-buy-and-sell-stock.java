class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, buy = prices[0];

        for (int num: prices) {
            if (num >= buy) {
                max = Math.max(max, num-buy);
            } else {
                buy = num; 
            }
        }

        return max;
    }
}