# 1. Best Time to Buy and Sell Stock

[Leetcode 121 (Easy)][121]

[121]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

```java
// approach 1
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (minPrice < prices[i])
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            else minPrice = prices[i];
        }
        return maxProfit;
    }
}

// approach 2
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}


```