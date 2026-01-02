class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long total = 0, maxSum = 0, sum = 0;
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i], s = strategy[i];
            total += p * s; // 不修改时的最大利润

            // 1. 下标为 i 的元素入右半，交易策略从 s 变成 1
            sum += p * (1 - s);

            if (i < k - 1) { // 尚未形成第一个窗口
                // 在下一轮循环中，下标为 i-k/2+1 的元素从右半移到左半，交易策略从 1 变成 0
                if (i >= k / 2 - 1) {
                    sum -= prices[i - k / 2 + 1];
                }
                continue;
            }

            // 2. 更新
            maxSum = Math.max(maxSum, sum); // 修改带来的最大额外利润

            // 3. 出，为下一个窗口做准备
            // 下标为 i-k/2+1 的元素从右半移到左半，交易策略从 1 变成 0，
            // 下标为 i-k+1 的元素从左半离开窗口，交易策略从 0 恢复为 strategy[i-k+1]
            sum -= prices[i - k / 2 + 1] - prices[i - k + 1] * strategy[i - k + 1];
        }
        return total + maxSum;
    }
}