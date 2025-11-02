class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price: prices) {
            if (price > minPrice) {
                maxProfit = Math.max(maxProfit, price - minPrice);
            } else {
                minPrice = price;
            }
        }

        return maxProfit;
    }
}